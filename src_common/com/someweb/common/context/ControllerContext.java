package com.someweb.common.context;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.someweb.common.helper.JSONHelper;

public class ControllerContext
{
	private static final String PARAMETERS = "com.someweb.common.context.ControllerContext.parameter";
	private static final String SESSION = "com.someweb.common.context.ControllerContext.session";
	private static final String SERVLETCONTEXT = "com.someweb.common.context.ControllerContext.servletcontext";
	private static ThreadLocal<ControllerContext> controllerContext = new ThreadLocal<ControllerContext>();
	
	private Map<String, Object> contextMap = new HashMap<String,Object>();
	
	public ControllerContext()
	{
	}
	
	public static void setContext(ControllerContext context)
	{
		controllerContext.set(context);
	}
	
	public static ControllerContext getContext()
	{
		return controllerContext.get();
	}
	
	public Map<String, Object> getContextMap()
	{
	    return this.contextMap;
	}
	
	public String getJSONParameter()
	{
		return (String)getContext().contextMap.get(PARAMETERS);
	}
	
	public void setJSONParameter(String jsonParameter)
	{
		this.contextMap.put(PARAMETERS, jsonParameter);
	}
	
	public <T> T getParameter(Class<T> clazz)
	{
		String json = getJSONParameter();
		return JSONHelper.decode(json, clazz);
	}
	
	public Map<String,Object> getParameterMap()
	{
		String json = getJSONParameter();
		return JSONHelper.decode(json);
	}
	
	public void  setSession(HttpSession session)
	{
		this.contextMap.put(SESSION, session);
	}
	
	public HttpSession getSession()
	{
		return (HttpSession) this.contextMap.get(SESSION);
	}
	
	public ServletContext getServletContext()
	{
		return (ServletContext) this.contextMap.get(SERVLETCONTEXT);
	}
	
	public void setServletContext(ServletContext servletContext)
	{
		this.contextMap.put(SERVLETCONTEXT, servletContext);
	}
}
