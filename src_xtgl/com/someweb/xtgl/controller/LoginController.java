package com.someweb.xtgl.controller;

import com.someweb.common.BaseController;
import com.someweb.common.constant.CommonConstant;
import com.someweb.common.helper.ControllerContextHelper;
import com.someweb.xtgl.bean.LoginInfo;
import com.someweb.xtgl.business.LoginBusiness;

/**
 * 用户登录控制类
 *com.someweb.xtgl.controller
 * @author 熊明春
 * 2015-12-13
 */
public class LoginController extends BaseController
{
	
	private LoginInfo loginInfo;
	
	private LoginBusiness loginBusiness;
	
	public LoginInfo login()
	{
		loginInfo = parameterBean.getParameter(LoginInfo.class);
		
		ControllerContextHelper.getSession().setAttribute(CommonConstant.LOGIN_INFO, loginInfo);
		return loginInfo;
	}
	
	public String toMain()
	{
		return SUCCESS;
	}
	
	public LoginInfo getLoginInfo()
	{
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo)
	{
		this.loginInfo = loginInfo;
	}
	public LoginBusiness getLoginBusiness()
	{
		return loginBusiness;
	}
	public void setLoginBusiness(LoginBusiness loginBusiness)
	{
		this.loginBusiness = loginBusiness;
	}
	
	
}
