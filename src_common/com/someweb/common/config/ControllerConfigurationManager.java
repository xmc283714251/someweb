package com.someweb.common.config;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.someweb.common.bean.BusinessBean;
import com.someweb.common.bean.ControllerBean;
import com.someweb.common.bean.LogicResultBean;
import com.someweb.common.bean.PropertyBean;
import com.someweb.common.exception.SomeWebException;

/**
 * some web 上下文配置文件加载机器
 *com.someweb.common.config
 * @author 熊明春
 * 2015-12-12
 */
public class ControllerConfigurationManager
{
	protected static final Logger LOG = Logger.getLogger(ControllerConfigurationManager.class);
	private static final String CONSTANT_NODE = "constant";
	private static final String CONSTANT_NAME = "name";
	private static final String CONSTANT_VALUE = "value";
	private static final String CONTROLLERS_NODE = "controllers";
	private static final String CONTROLLER_NODE = "controller";
	private static final String CONTROLLER_ID = "id";
	private static final String CONTROLLER_CLASS = "class";
	private static final String RESULT_NODE = "result";
	private static final String RESULTS_NODE = "results";
	private static final String PROPERTY_NODE = "property";
	private static final String PROPERTY_NAME = "name";
	private static final String PROPERTY_REF = "ref";
	private static final String RESULT_NAME = "name";
	private static final String RESULT_TYPE = "type";
	private static final String INCLUDE_NODE = "include";
	private static final String INCLUDE_FILE = "file";
	private static final String GLOBAL_RESULT = "global-results";
	private static final String BUSINESSES_NODE = "businesses";
	private static final String BUSINESS_NODE = "business";
	private static final String BUSINESS_ID = "id";
	private static final String BUSINESS_CLASS = "class";
	
	private static final String RESULT_TYPE_JSON = "json";
	//全局参数
	private static Map<String,String> constantParameter = new ConcurrentHashMap<String, String>();
	
	//业务对象
	private static Map<String, BusinessBean> businessMap = new ConcurrentHashMap<String, BusinessBean>();
	
	//控制着
	private static Map<String,ControllerBean> controllerMap = new ConcurrentHashMap<String, ControllerBean>();
	
	//全局返回类型
	private static Map<String,LogicResultBean> globalResultTypeMap = new ConcurrentHashMap<String,LogicResultBean>();
	
	
	//配置文件路径
	private String configFilePath;
	
	
	public ControllerConfigurationManager(String configFilePath)
	{
		this.configFilePath = configFilePath;
	}
	
	public static Map<String,String> getConstantParameter()
	{
		return constantParameter;
	}
	
	/**
	 * 获取所有的控制着
	 * @return Map<String,ControllerBean>
	 * @author 熊明春
	 * @date 2015-12-13下午8:54:11
	 */
	public static Map<String,ControllerBean> getControllers()
	{
		return controllerMap;
	}
	
	/**
	 * 获取控制着对象
	 * @param controllerId
	 * @return ControllerBean
	 * @author 熊明春
	 * @date 2015-12-13下午8:54:00
	 */
	public static ControllerBean getController(String controllerId)
	{
		return controllerMap.get(controllerId);
	}
	
	/**
	 * 获取业务对象
	 * @param businessid
	 * @return BusinessBean
	 * @author 熊明春
	 * @date 2015-12-13下午8:53:44
	 */
	public static BusinessBean getBusiness(String businessid)
	{
		return businessMap.get(businessid);
	}
	
	/**
	 * 
	 * @param name
	 * @return LogicResultBean
	 * @author 熊明春
	 * @date 2015-12-13下午7:01:11
	 */
	public static LogicResultBean getGlobResults(String name)
	{
		return globalResultTypeMap.get(name);
	}
	
	public void loadConfigFile()
	{
		loadConfigFile(configFilePath);
	}
	
	@SuppressWarnings("unchecked")
	public void loadConfigFile(String path)
	{
		LOG.info("开始装载配置文件[" + path + "].");
		try
		{
			SAXReader reader = new SAXReader();
			Document document = reader.read(ControllerConfigurationManager.class.getResourceAsStream(path));
			Element root = document.getRootElement();
			
			//读取静态常量配置 constant
			Iterator<Element> constantIterator = root.elementIterator(CONSTANT_NODE);
			readConstantNode(constantIterator);
			
			//读取全局返回参数 result-type
			Iterator<Element> globalResultIterator = root.elementIterator(GLOBAL_RESULT);
			readGlobalResults(globalResultIterator);
			
			//读取业务对象 business
			Iterator<Element> businessesIterator = root.elementIterator(BUSINESSES_NODE);
			readBusinessNode(businessesIterator);
			
			//读取控制类 controller
			Iterator<Element> controllersIterator = root.elementIterator(CONTROLLERS_NODE);
			readControllerNode(controllersIterator);
			
			//读取包含文件配置 include
			Iterator<Element> includeIterator = root.elementIterator(INCLUDE_NODE);
			while(includeIterator.hasNext())
			{
				Element controller = includeIterator.next();
				String filePath = controller.attributeValue(INCLUDE_FILE);
				loadConfigFile(filePath);
			}
		}
		catch(Exception e)
		{
			LOG.error("load config file failure,please check then file [" + path + "] if is empty.",e);
		}
	}
	
	/**
	 * 读取业务business逻辑对象节点
	 * @param businessesItarator
	 * @throws SomeWebException void
	 * @author 熊明春
	 * @date 2015-12-13下午8:22:19
	 */
	@SuppressWarnings("unchecked")
	private void readBusinessNode(Iterator<Element> businessesIterator) throws SomeWebException
	{
		while(businessesIterator.hasNext())
		{
			Element businesses = businessesIterator.next();
			Iterator<Element> businessIterator = businesses.elementIterator(BUSINESS_NODE);
			BusinessBean businessBean = null;
			while(businessIterator.hasNext())
			{
				businessBean = new BusinessBean();
				Element business = businessIterator.next();
				String businessid = business.attributeValue(BUSINESS_ID);
				String classname = business.attributeValue(BUSINESS_CLASS);
				businessBean.setId(businessid);
				businessBean.setClassname(classname);
				if (!businessMap.containsKey(businessid))
				{
					try
					{
						Class<?> clazz = Class.forName(classname);
						businessBean.setClazz(clazz);
					} 
					catch (ClassNotFoundException e)
					{
						throw new SomeWebException("[" + classname + "] can not load，case by class not found." , e);
					}
					businessMap.put(businessid, businessBean);
				}
				else
				{
					throw new SomeWebException("business[" + businessid + "] is configured on many times，the must be only one.");
				}
				
			}
		}
	}
	
	/**
	 * 迭代Constant Node
	 * @param iterator void
	 * @author 熊明春
	 * @date 2015-12-12下午4:32:04
	 */
	private void readConstantNode(Iterator<Element> iterator) throws SomeWebException
	{
		while(iterator.hasNext())
		{
			Element constant = iterator.next();
			String name = constant.attributeValue(CONSTANT_NAME);
			String value = constant.attributeValue(CONSTANT_VALUE);
			
			if (!controllerMap.containsKey(name))
			{
				constantParameter.put(name, value);
			}
			else
			{
				throw new SomeWebException("constant[" + name + "] is configured on many times，the must be only one.");
			}
		}
	}
	
	/**
	 * 读全局返回结果类型
	 * @param iterator
	 * @throws SomeWebException void
	 * @author 熊明春
	 * @date 2015-12-13下午6:54:11
	 */
	@SuppressWarnings("unchecked")
	private void readGlobalResults(Iterator<Element> iterator) throws SomeWebException
	{
		while(iterator.hasNext())
		{
			Element globalresult = iterator.next();
			Iterator<Element> resultIterator = globalresult.elementIterator(RESULT_NODE);
			LogicResultBean resultBean = null;
			while(resultIterator.hasNext())
			{
				resultBean = new LogicResultBean();
				Element result = resultIterator.next();
				String name = result.attributeValue(RESULT_NAME);
				String type = result.attributeValue(RESULT_TYPE) != null ? result.attributeValue(RESULT_TYPE) : RESULT_TYPE_JSON;
				String path = result.getTextTrim();
				resultBean.setName(name);
				resultBean.setResultType(type);
				resultBean.setPath(path);
				globalResultTypeMap.put(name, resultBean);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void readControllerNode(Iterator<Element> controllersiterator) throws SomeWebException
	{
		//迭代节点
		while(controllersiterator.hasNext())
		{
			Element controllers = controllersiterator.next();
			Iterator<Element> controllerIterator = controllers.elementIterator(CONTROLLER_NODE);
			ControllerBean controllerBean = null;
			while(controllerIterator.hasNext())
			{
				controllerBean = new ControllerBean();
				Element controller = controllerIterator.next();
				String id = controller.attributeValue(CONTROLLER_ID);
				String classname = controller.attributeValue(CONTROLLER_CLASS);
				controllerBean.setId(id);
				controllerBean.setClassName(classname);
				if (!controllerMap.containsKey(id))
				{
					try
					{
						Class<?> clazz = Class.forName(classname);
						controllerBean.setClazz(clazz);
					} 
					catch (ClassNotFoundException e)
					{
						throw new SomeWebException("[" + classname + "] can not load，case by class not found." , e);
					}
					//找节点<results>遍历 result节点
					Iterator<Element> resultsIterator = controller.elementIterator(RESULTS_NODE);
					while(resultsIterator.hasNext())
					{
						Element results = resultsIterator.next();
						//找节点<result>
						Iterator<Element> resultIterator = results.elementIterator(RESULT_NODE);
						LogicResultBean resultBean = null;
						while(resultIterator.hasNext())
						{
							resultBean = new LogicResultBean();
							Element result = resultIterator.next();
							String name = result.attributeValue(RESULT_NAME);
							String type = result.attributeValue(RESULT_TYPE) != null ? result.attributeValue(RESULT_TYPE) : RESULT_TYPE_JSON;
							String path = result.getTextTrim();
							resultBean.setName(name);
							resultBean.setResultType(type);
							resultBean.setPath(path);
							controllerBean.getResultMap().put(name, resultBean);
						}
					}
					
					//遍历property节点
					Iterator<Element> propertyIterator = controller.elementIterator(PROPERTY_NODE);
					PropertyBean propertyBean = null;
					while(propertyIterator.hasNext())
					{
						propertyBean = new PropertyBean();
						Element property = propertyIterator.next();
						String name = property.attributeValue(PROPERTY_NAME);
						String ref = property.attributeValue(PROPERTY_REF);
						propertyBean.setName(name);
						propertyBean.setRef(ref);
						
						controllerBean.getPropertyMap().put(name, propertyBean);
					}
					controllerMap.put(id, controllerBean);
				}
				else
				{
					throw new SomeWebException("controller[" + id + "] is configured on many times，the must be only one.");
				}
				
			}
		}
	}
	
	
}
