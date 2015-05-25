package com.someweb.common.helper;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.someweb.common.bean.LoginInfo;
import com.someweb.common.constant.CommonConstant;


public class ActionContextHelper 
{
	
	public static LoginInfo getLoginInfo()
	{
		ActionContext context = ActionContext.getContext();
		if (context != null)
		{
			return (LoginInfo)ActionContext.getContext().getSession().get(CommonConstant.LOGIN_INFO);
		}
		else
		{
			return null;
		}
	}
	
	public static int getInlineNum()
	{
		return (Integer)ActionContext.getContext().getSession().get("inlineNum");
	}
	
	public static void setLoginInfo(LoginInfo loginInfo)
	{
		ActionContext.getContext().getSession().put(CommonConstant.LOGIN_INFO, loginInfo);
	}
	
	public static ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}
	
	 
}
