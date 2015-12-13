package com.someweb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerSupport
{
	public static final String SUCCESS = "success";
	
	public static final String ERROR = "error";
	
	public abstract void setRequest(HttpServletRequest request);
	
	public abstract void setResponse(HttpServletResponse response);
}
