package com.someweb.common.servlet;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.someweb.common.ControllerSupport;
import com.someweb.common.ParameterController;
import com.someweb.common.bean.BusinessBean;
import com.someweb.common.bean.ControllerBean;
import com.someweb.common.bean.FileUploadBean;
import com.someweb.common.bean.LogicResultBean;
import com.someweb.common.bean.ParameterBean;
import com.someweb.common.bean.PropertyBean;
import com.someweb.common.config.ControllerConfigurationManager;
import com.someweb.common.constant.CommonConstant;
import com.someweb.common.context.ControllerContext;
import com.someweb.common.exception.SomeWebException;
import com.someweb.common.helper.JSONHelper;
import com.someweb.common.helper.PropertyDescriptorHelper;
import com.someweb.common.helper.ValidateHelper;

/**
 * SomeWeb框架总控制Servlet
 * 请求方式 http://ip:port/上下文名称/business?controller=controllerId&action=saveMethod
 *com.someweb.common.servlet
 * @author 熊明春
 * 2015-12-12
 */
public class SomeWebInterceptorServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4774514878158341123L;
	private static final String ERROR_PAGE_404 = "404";
	private static final String GLOBAL_FORM_PARAMETER = "parameters";
	private static final String CONTROLLER = "controller";
	private static final String CONTROLLER_METHOD = "action";
	private static final String DEFAULT_CONFIG_FILE_PATH = "/someweb.xml";
	private String configFilePath;
	private String encodeing = "UTF-8";
	private String controller;
	private String action;
	
	/**
	 * Constructor of the object.
	 */
	public SomeWebInterceptorServlet()
	{
		super();
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		configFilePath = getServletConfig().getInitParameter("configFilePath");
		if (ValidateHelper.isEmptyString(configFilePath))
		{
			configFilePath = DEFAULT_CONFIG_FILE_PATH;
		}
		//控制类加载器
		ControllerConfigurationManager manager = new ControllerConfigurationManager(configFilePath);
		manager.loadConfigFile();
	}
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ParameterBean parameterBean = new ParameterBean();
		try
		{
			//创建控制类上下文对象
			ControllerContext context = new ControllerContext();
			//存放进入当前线程
			ControllerContext.setContext(context);
			//获取系统参数
			String jsonparams = request.getParameter(GLOBAL_FORM_PARAMETER);
			//设置系统参数
			context.setJSONParameter(jsonparams);
			//设置Session 静态化，方便获取
			context.setSession(request.getSession());
			//设置Servlet Context 方便静态获取
			context.setServletContext(request.getServletContext());
			
			//创建参数对象
			parameterBean.setJsonParameters(jsonparams);
			
			//处理文件上传,并且封装到参数对象中
			handlerFileUpload(request, response,parameterBean);
			request.setAttribute(GLOBAL_FORM_PARAMETER, parameterBean);
			
			controller = request.getParameter(CONTROLLER);
			request.setAttribute(CONTROLLER, controller);
			action = request.getParameter(CONTROLLER_METHOD);
			
			//系统编码
			encodeing = ControllerConfigurationManager.getConstantParameter().get(CommonConstant.SOMEWEB_I18N_ENCODING);
			encodeing = ValidateHelper.isNotEmptyString(encodeing) ? encodeing : "UTF-8";
			//获取控制着
			ControllerBean controllerBean = ControllerConfigurationManager.getController(controller);
			doForwardHandler(request, response, controllerBean,parameterBean);
				 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			response.getWriter().close();
			//删除上传附件的临时文件
			List<FileUploadBean> uploadFiles = parameterBean.getUploadFiles();
			if (ValidateHelper.isNotEmptyCollection(uploadFiles))
			{
				for (FileUploadBean bean : uploadFiles)
				{
					bean.getFile().deleteOnExit();
				}
			}
			
		}
	}
	
	/**
	 * 做页面逻辑判断处理
	 * @param request http请求对象
	 * @param response http返回对象
	 * @param controller 控制着对象
	 * @param resultObject controller类返回结果
	 * @author 熊明春
	 * @date 2015-12-12下午11:46:33
	 */
	private void doForwardHandler(HttpServletRequest request, HttpServletResponse response,ControllerBean controller,ParameterBean parameterBean)
	{
		try
		{
			if (controller != null)
			{
				//实例化controller对象
				Object controllerObject = controller.getClazz().newInstance();
				
				//给get set 方法对象注入值
				handlerControllerInjectionValue(request, response, controller, parameterBean, controllerObject);
				
				//调用controller方法执行业务逻辑处理
				Method controllerMethod = controller.getClazz().getMethod(action);
				Object resultObject = controllerMethod.invoke(controllerObject);
				
				//获取返回值类型
				Class<?> resultClazz = controllerMethod.getReturnType();
				
				//返回字符串逻辑
				if (resultObject != null && "String".equals(resultClazz.getSimpleName()))
				{
					LogicResultBean resultBean = controller.getResultMap().get(resultObject);
					//找到逻辑返回对象，做页面跳转
					if (resultBean != null)
					{
						String path = resultBean.getPath();
						String returnType = resultBean.getResultType();
						if ("redirect".equals(returnType))
						{
							response.sendRedirect(request.getContextPath() + path);
						}
						else
						{
							//读取所有的property的get方法，把结果存放进入request中
							PropertyDescriptor[] pdarray = PropertyDescriptorHelper.getPropertyDescriptorArray(controller.getClazz());
							if (ValidateHelper.isNotEmptyArray(pdarray))
							{
								for (PropertyDescriptor pd : pdarray)
								{
									if (!"class".equals(pd.getName()))
									{
										Method readMethod = pd.getReadMethod();
										if (readMethod != null)
										{
											Object getMethodReturnObject = readMethod.invoke(controllerObject);
											request.setAttribute(pd.getName(), getMethodReturnObject);
										}
									}
								}
							}
							request.getRequestDispatcher(path).forward(request,response);
						}
					}
					//没找到逻辑返回对象默认使用Ajax返回
					else
					{
						response.getWriter().write(resultObject.toString());
					}
				}
				else
				{
					response.setCharacterEncoding(encodeing);
					response.setContentType("text/plain;Charset=" + encodeing);
					response.setHeader("Cache-Control", "no-cache");
					String json = JSONHelper.encode(resultObject);
					response.getWriter().write(json);
				}
			}
			//404页面返回
			else
			{
				
				LogicResultBean resultBean = ControllerConfigurationManager.getGlobResults(ERROR_PAGE_404);
				if (resultBean != null)
				{
					response.sendRedirect(request.getContextPath() + resultBean.getPath());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 给controller注入set 值对象
	 * @param request
	 * @param response
	 * @param controller
	 * @param parameterBean void
	 * @author 熊明春
	 * @date 2015-12-13下午8:41:50
	 */
	private void handlerControllerInjectionValue(HttpServletRequest request, HttpServletResponse response,ControllerBean controller,ParameterBean parameterBean,Object controllerObject) throws Exception
	{
		 
		//实现了Controller方法
		if (controllerObject instanceof ParameterController)
		{
			Method setParameterBeanMethod = controller.getClazz().getMethod("setParameterBean", ParameterBean.class);
			setParameterBeanMethod.invoke(controllerObject, parameterBean);
		}
		//设置http对象
		if (controllerObject instanceof ControllerSupport)
		{
			Method httpRequestSetMethod = controller.getClazz().getMethod("setRequest", HttpServletRequest.class);
			httpRequestSetMethod.invoke(controllerObject, request);
			Method httpResponseSetMethod = controller.getClazz().getMethod("setResponse", HttpServletResponse.class);
			httpResponseSetMethod.invoke(controllerObject, response);
		}
		Map<String, PropertyBean> propertyBeanMap = controller.getPropertyMap();
		if (ValidateHelper.isNotEmptyMap(propertyBeanMap))
		{
			for (Map.Entry<String, PropertyBean> entry : propertyBeanMap.entrySet())
			{
				PropertyBean propertyBean = entry.getValue();
				String propertyName = propertyBean.getName();
				String ref = propertyBean.getRef();
				BusinessBean businessBean = ControllerConfigurationManager.getBusiness(ref);
				if (businessBean != null)
				{
					//调用set 方法给controller property 赋值
					PropertyDescriptorHelper.invokeWriteMethod(controllerObject,propertyName, businessBean.getClazz().newInstance());
				}
				else
				{
					throw new SomeWebException("property attribute ref [" + ref + "] not found.");
				}
				
			}
		}
		 
	}
	
	/**
	 * 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，  
     * 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同  
     * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，  
     * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的  
     * 然后再将其真正写到 对应目录的硬盘上 
	 * @param request
	 * @param response
	 * @return Map<String,ArrayList<FileUploadBean>>
	 * @author 熊明春
	 * @date 2015-12-12下午8:00:30
	 */
	@SuppressWarnings({"unchecked" })
	private void handlerFileUpload(HttpServletRequest request, HttpServletResponse response,ParameterBean parameterBean)
	{
		try
		{
			if (ServletFileUpload.isMultipartContent(request))
			{
				DiskFileItemFactory factory = new DiskFileItemFactory();
			        
				//取得上传文件
				String maxSize = ControllerConfigurationManager.getConstantParameter().get(CommonConstant.SOMEWEB_MULTIPART_MAXSIZE);
				
				//默认10M
				int fileMaxSize = ValidateHelper.isNotEmptyString(maxSize) ? Integer.parseInt(maxSize) : 10 * 1024*1024;  
				
				//设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
				factory.setSizeThreshold(fileMaxSize);
				//上传文件临时存放目录
				String filePath = ControllerConfigurationManager.getConstantParameter().get(CommonConstant.SOMEWEB_MULTIPART_SAVEDIR);
				String saveDir = getServletContext().getRealPath("") + (ValidateHelper.isNotEmptyString(filePath) ? filePath : "/uploadtmp");
				File f = new File(saveDir);
				if (!f.exists())
				{
					f.mkdir();
				}
				factory.setRepository(f);  
				ServletFileUpload upload = new ServletFileUpload(factory);
				//可以上传多个文件  
	            List<FileItem> list = upload.parseRequest(request);
	            FileUploadBean uploadBean = null;
				for (FileItem fileItem : list)
				{
					 //获取表单的属性名字  
	                String name = fileItem.getFieldName();
	                if(!fileItem.isFormField())
	                {
	                	uploadBean = new FileUploadBean();
	                	uploadBean.setName(name);
	                	//获取路径名  
	                    String value = fileItem.getName();
	                    //索引到最后一个反斜杠  
	                    int start = value.lastIndexOf("\\");  
	                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
	                    String filename = value.substring(start+1);
	                    uploadBean.setFileName(filename);
	                    uploadBean.setContentType(fileItem.getContentType());
	                    
	                    //获取文件后缀
	                    int pos = filename.lastIndexOf(".");
	                    if (pos != -1)
	                    {
	                    	String suffix = filename.substring(pos);
	                    	uploadBean.setFileSuffix(suffix);
	                    }
	                    
	                    String newFileName = UUID.randomUUID().toString().toUpperCase() + ".tmp";
	                    uploadBean.setTempPath(saveDir +"/" + newFileName);
	                    
	                    //文件输出并且存放进入临时文件
	                    File tmpFile = new File(saveDir,newFileName);
	                    OutputStream out = new FileOutputStream(tmpFile);
	                    InputStream in = fileItem.getInputStream();
	                    int length = 0 ;  
	                    byte [] buf = new byte[1024];
	                    
	                    // buf 数组中 取出数据写到（输出流）磁盘上  
	                    while( (length = in.read(buf) ) != -1)  
	                    {  
	                        out.write(buf, 0, length);  
	                    }
	                    in.close();
	                    out.close();
	                    uploadBean.setFile(tmpFile);
	                    
	                    parameterBean.getUploadFiles().add(uploadBean);
	                }
				}
			}
		} 
		catch (FileUploadException e) 
		{  
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}  
	}
		
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); 
	}

	public String getConfigFilePath()
	{
		return configFilePath;
	}

	public void setConfigFilePath(String configFilePath)
	{
		this.configFilePath = configFilePath;
	}
	
	
}
