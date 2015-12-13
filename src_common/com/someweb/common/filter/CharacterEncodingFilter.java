package com.someweb.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 参数编码过滤器
 *com.someweb.common.filter
 * @author 熊明春
 * 2015-12-12
 */
public class CharacterEncodingFilter extends HttpFilter
{
	private String encoding = "UTF-8";
	
	@Override
	public void doHttpFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)  
					throws IOException, ServletException
	{
		encoding = filterParameters.get("encoding");
		if (this.encoding != null || (request.getCharacterEncoding() == null)) 
		{
		      request.setCharacterEncoding(this.encoding);
		      response.setCharacterEncoding(this.encoding);
		}
	}
	 
	
}
