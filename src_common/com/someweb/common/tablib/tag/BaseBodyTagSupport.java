package com.someweb.common.tablib.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.someweb.common.tablib.bean.TagPropertyBean;
import com.someweb.common.tablib.helper.TagTemplateHelper;

import freemarker.template.Template;

public abstract class BaseBodyTagSupport extends BodyTagSupport
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6231634579897165396L;

	private TagPropertyBean bean = null;
	
	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			bean = new TagPropertyBean();
			setTagPropertyBean(bean);
			Template temp = TagTemplateHelper.getTemplate(getStartTempFileName());
			temp.process(bean.getRoot(), pageContext.getOut());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			Template temp = TagTemplateHelper.getTemplate(getEndTempFileName());
			temp.process(bean.getRoot(), pageContext.getOut());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	
	
	public abstract String getStartTempFileName();
	
	public abstract String getEndTempFileName();
	
	public abstract void setTagPropertyBean(TagPropertyBean bean);
	
}
