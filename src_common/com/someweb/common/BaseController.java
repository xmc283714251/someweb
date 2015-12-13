package com.someweb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.someweb.common.bean.ParameterBean;

public class BaseController implements ControllerSupport, ParameterController
{
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected ParameterBean parameterBean;
	
	@Override
	public void setParameterBean(ParameterBean parameterBean)
	{
		this.parameterBean = parameterBean;
	}

	@Override
	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	@Override
	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}

}
