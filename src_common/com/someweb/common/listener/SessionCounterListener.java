package com.someweb.common.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener
{
	public static int inlineNum = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		inlineNum++;
		event.getSession().setAttribute("inlineNum", inlineNum);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		inlineNum--;
	}
	
}
