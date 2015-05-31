package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 表格工具栏标签
 * com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-5-31
 */
public class ToolBarTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249043040360971431L;

	@Override
	public String getStartTempFileName()
	{
		return "toolbar_start.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return "toolbar_end.ftl";
	}

	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		TagTemplateHelper.converTagPropertyToBean(this, bean);
	}

}
