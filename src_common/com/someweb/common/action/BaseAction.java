package com.someweb.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

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

	
	public PagerFormBean getPagerForm()
	{
		return pagerForm;
	}

	public void setPagerForm(PagerFormBean pagerForm)
	{
		this.pagerForm = pagerForm;
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
	
}
