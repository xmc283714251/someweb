package com.someweb.common.taglib.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.someweb.common.helper.ValidateHelper;
import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

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
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			bean = new TagPropertyBean();
			setTagPropertyBean(bean);
			String contextPath = request.getContextPath();
			bean.getRoot().put("contextPath", contextPath);
			String startTemplate = getStartTempFileName();
			if (ValidateHelper.isNotEmptyString(startTemplate))
			{
				Template temp = TagTemplateHelper.getTemplate(getStartTempFileName());
				temp.process(bean.getRoot(), pageContext.getOut());
			}
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
			String endTemplate = getEndTempFileName();
			if (ValidateHelper.isNotEmptyString(endTemplate))
			{
				Template temp = TagTemplateHelper.getTemplate(endTemplate);
				temp.process(bean.getRoot(), pageContext.getOut());
			}
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
