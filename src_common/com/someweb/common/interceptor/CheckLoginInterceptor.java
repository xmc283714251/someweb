package com.someweb.common.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.someweb.common.action.LoginAction;
import com.someweb.common.constant.CommonConstant;

public class CheckLoginInterceptor extends AbstractInterceptor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -950025376057418035L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Object loginInfo = invocation.getInvocationContext().getSession().get(CommonConstant.LOGIN_INFO);
		Object actionObject = invocation.getAction();
		if (actionObject instanceof LoginAction)
		{
			return invocation.invoke();
		}
		else
		{
			if (loginInfo != null)
			{
				return invocation.invoke();
			}
			else
			{
				return "notlogin";
			}
		}
	}
	 
	
}
