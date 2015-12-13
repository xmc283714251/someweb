package com.someweb.test.action;

import com.someweb.common.ParameterController;
import com.someweb.common.bean.ParameterBean;

public class TestController implements ParameterController
{
	private ParameterBean parameterBean;
	
	public void saveInfo()
	{
		System.out.println(parameterBean.getJsonParameters());
	}
	
	public String insertInfo()
	{
		return "success1";
	}

	@Override
	public void setParameterBean(ParameterBean parameterBean)
	{
		this.parameterBean = parameterBean;
	}
}
