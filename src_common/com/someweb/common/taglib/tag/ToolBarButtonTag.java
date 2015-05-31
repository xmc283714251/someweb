package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 工具栏中的操作按钮
 * com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-5-31
 */
public class ToolBarButtonTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1426740626039570142L;
	
	//对应 add，delete，edit line，icon
	private String type;
	// 对应 navTab，dialog,ajaxTodo
	private String target;
	
	// navTab，dialog
	private String targetType;
	
	private String action;
	
	private String text;
	
	private String operaTip;
	
	
	@Override
	public String getStartTempFileName()
	{
		return "toolbarbutton.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return null;
	}

	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		TagTemplateHelper.converTagPropertyToBean(this, bean);
		
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getOperaTip()
	{
		return operaTip;
	}

	public void setOperaTip(String operaTip)
	{
		this.operaTip = operaTip;
	}

	public String getTargetType()
	{
		return targetType;
	}

	public void setTargetType(String targetType)
	{
		this.targetType = targetType;
	}
	
}
