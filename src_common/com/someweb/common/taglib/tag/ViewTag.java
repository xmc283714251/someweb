package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

public class ViewTag extends BaseBodyTagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2279956658646491458L;
	private String title;
	
	@Override
	public String getStartTempFileName()
	{
		return "view_start.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return "view_end.ftl";
	}

	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		TagTemplateHelper.converTagPropertyToBean(this, bean);
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
}
