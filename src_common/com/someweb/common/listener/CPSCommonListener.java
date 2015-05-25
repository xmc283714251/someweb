package com.someweb.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.someweb.common.helper.DictionaryCacheHellper;

/**
 * 系统初始化监听
 * @author 熊明春
 *
 */
public class CPSCommonListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) 
	{
		
	}

	public void contextInitialized(ServletContextEvent context) 
	{
		DictionaryCacheHellper.initCache();
	}
	
}