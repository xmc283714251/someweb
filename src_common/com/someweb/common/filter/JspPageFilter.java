package com.someweb.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.someweb.common.bean.LoginInfo;
import com.someweb.common.helper.ActionContextHelper;

public class JspPageFilter implements Filter
{

	@Override
	public void destroy()
	{
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		LoginInfo loginInfo = ActionContextHelper.getLoginInfo();
		String servletpath = request.getServletPath();
		//登录也不拦截
		if (servletpath.equals("/index.jsp"))
		{
			chain.doFilter(arg0, arg1);
		}
		else if (loginInfo == null)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			chain.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
	}

}
