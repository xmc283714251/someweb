package com.someweb.test.action;

import com.someweb.xtgl.bean.LoginInfo;

public class TestBean
{
	private LoginInfo loginInfo;
	
	private QueryBean queryBean;

	public LoginInfo getLoginInfo()
	{
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo)
	{
		this.loginInfo = loginInfo;
	}

	public QueryBean getQueryBean()
	{
		return queryBean;
	}

	public void setQueryBean(QueryBean queryBean)
	{
		this.queryBean = queryBean;
	}
	
	
}
