package com.someweb.common.action;

import com.someweb.common.bean.PagerFormBean;

/**
 * 基本的Action
 * @author xmc
 *
 */
public class BaseAction
{
	private PagerFormBean pagerForm;

	public PagerFormBean getPagerForm()
	{
		return pagerForm;
	}

	public void setPagerForm(PagerFormBean pagerForm)
	{
		this.pagerForm = pagerForm;
	}
	
	
}
