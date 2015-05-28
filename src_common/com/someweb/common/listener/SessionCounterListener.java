package com.someweb.common.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.someweb.common.constant.CommonConstant;

public class SessionCounterListener implements HttpSessionListener
{
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		Object numObject = event.getSession().getAttribute(CommonConstant.CURRENT_INLINE_NUM);
		if (numObject != null)
		{
			int inlineNum = (Integer)numObject;
			event.getSession().setAttribute(CommonConstant.CURRENT_INLINE_NUM, inlineNum++);
		}
		else
		{
			event.getSession().setAttribute(CommonConstant.CURRENT_INLINE_NUM, 1);
		}
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		Object numObject = event.getSession().getAttribute(CommonConstant.CURRENT_INLINE_NUM);
		int inlineNum = (Integer)numObject;
		event.getSession().setAttribute(CommonConstant.CURRENT_INLINE_NUM, inlineNum -1);
	}
	
}
