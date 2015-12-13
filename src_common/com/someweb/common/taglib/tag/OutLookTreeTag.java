package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * mini-outlooktree
 *com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-12-10
 */
public class OutLookTreeTag extends BaseBodyTagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9008136094568648571L;
	private String id;
	private String url;
	private String onnodeclick;
	private String idField = "funid";
	private String textField = "funtext";
	private String parentField = "parentid";
	@Override
	public String getStartTempFileName()
	{
		return "outlooktree.ftl";
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

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getOnnodeclick()
	{
		return onnodeclick;
	}

	public void setOnnodeclick(String onnodeclick)
	{
		this.onnodeclick = onnodeclick;
	}

	public String getIdField()
	{
		return idField;
	}

	public void setIdField(String idField)
	{
		this.idField = idField;
	}

	public String getTextField()
	{
		return textField;
	}

	public void setTextField(String textField)
	{
		this.textField = textField;
	}

	public String getParentField()
	{
		return parentField;
	}

	public void setParentField(String parentField)
	{
		this.parentField = parentField;
	}
	
	
}
