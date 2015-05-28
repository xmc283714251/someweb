package com.someweb.common.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
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
		if (loginInfo != null)
		{
			return invocation.invoke();
		}
		else
		{
			String namespace = invocation.getProxy().getNamespace();
			String actionName = invocation.getInvocationContext().getName();
			String path = namespace + actionName;
			if ("/login".equals(path))
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
