package com.someweb.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.someweb.common.bean.PagerFormBean;

/**
 * 基本的Action
 * @author xmc
 *
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7838241225400335581L;
	
	/**
	 * action控制类名称
	 */
	private String action;
	
	/**
	 * 业务处理方法
	 */
	private String business;
	
	protected HttpSession session;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	private PagerFormBean pagerForm;
	
	private int pageNum = 1;
	
	private int numPerPage = 20;
	
	private String orderField;
	
	private String orderDirection;
	
	/**
	 * 输出文本
	 * @param object
	 * @return
	 */
	protected String responseWrite(Object object)
	{
		try 
		{
			String resStr = JSONUtil.serialize(object);
			this.returnValue(resStr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void returnValue(String resStr)
	{
		try
		{
			Object obj = getSession().getServletContext().getAttribute("encoding"); 
			String encoding = obj != null ? obj.toString() : "UTF-8";
			response.setCharacterEncoding(encoding);
			response.setContentType("text/plain;Charset=" + encoding);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(resStr);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public PagerFormBean getPagerForm()
	{
		if (pagerForm == null)
		{
			pagerForm = new PagerFormBean();
		}
		pagerForm.setCurrentPage(pageNum);
		pagerForm.setPageNum(pageNum);
		pagerForm.setNumPerPage(numPerPage);
		pagerForm.setOrderDirection(orderDirection);
		pagerForm.setOrderField(orderField);
		return pagerForm;
	}
	
	public void setServletRequest(HttpServletRequest request) 
	{
		this.request = request;
		this.session = request.getSession();
	}

	public void setServletResponse(HttpServletResponse response) 
	{
		this.response = response;
	}
	
	/**
	 * 获取HttpSession对象
	 * 
	 * @return HttpSession
	 */
	public HttpSession getSession() {
		
		return getRequest().getSession();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}


	public String getAction()
	{
		return action;
	}


	public void setAction(String action)
	{
		this.action = action;
	}


	public String getBusiness()
	{
		return business;
	}


	public void setBusiness(String business)
	{
		this.business = business;
	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public int getNumPerPage()
	{
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage)
	{
		this.numPerPage = numPerPage;
	}

	public String getOrderField()
	{
		return orderField;
	}

	public void setOrderField(String orderField)
	{
		this.orderField = orderField;
	}

	public String getOrderDirection()
	{
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection)
	{
		this.orderDirection = orderDirection;
	}
	
}
