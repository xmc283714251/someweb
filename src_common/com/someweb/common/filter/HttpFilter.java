package com.someweb.common.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象的HttpFilter
 *com.someweb.common.filter
 * @author 熊明春
 * 2015-12-12
 */
public abstract class HttpFilter implements Filter
{
	protected Map<String, String> filterParameters = new HashMap<String, String>();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		Enumeration<String> parameterNames =  filterConfig.getInitParameterNames();
		while(parameterNames.hasMoreElements())
		{
			String parameterName = parameterNames.nextElement();
			filterParameters.put(parameterName, filterConfig.getInitParameter(parameterName));
		}
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		doHttpFilter(request, response, chain);
		chain.doFilter(arg0, arg1);
	}
	
	
	@Override
	public void destroy()
	{
	}
	
	public abstract void doHttpFilter(HttpServletRequest request, HttpServletResponse response,FilterChain chain)  throws IOException, ServletException;
}
