package com.someweb.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import com.someweb.common.bean.PagerFormBean;

/**
 * 基本的Action
 * @author xmc
 *
 */
public class BaseAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7838241225400335581L;
	
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
	
}
