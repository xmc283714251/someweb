package com.someweb.common.helper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.someweb.common.context.ControllerContext;

/**
 * 控制着上下文帮助类
 *com.someweb.common.helper
 * @author 熊明春
 * 2015-12-13
 */
public class ControllerContextHelper
{
	/**
	 * 获取当前session
	 * @return HttpSession
	 * @author 熊明春
	 * @date 2015-12-13下午5:23:32
	 */
	public static HttpSession getSession()
	{
		return  ControllerContext.getContext().getSession();
	}
	
	/**
	 * 获取Servlet Context
	 * @return ServletContext
	 * @author 熊明春
	 * @date 2015-12-13下午5:24:13
	 */
	public static ServletContext getServletContext()
	{
		return ControllerContext.getContext().getServletContext();
	}
}
