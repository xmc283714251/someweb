package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 如期控件
 *com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-6-19
 */
public class DateTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1840294367107532589L;
	private String id;
	private String name;
	private String value;
	private String label;
	private boolean required = false;	//required
	private String format = "yyyy-MM-dd"; //yyyy-MM-dd HH:mm:ss
	private int yearstart = -30;
	private int yearend = 30;
	@Override
	public String getStartTempFileName()
	{
		return "date_start.ftl";
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public boolean isRequired()
	{
		return required;
	}

	public void setRequired(boolean required)
	{
		this.required = required;
	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public int getYearstart()
	{
		return yearstart;
	}

	public void setYearstart(int yearstart)
	{
		this.yearstart = yearstart;
	}

	public int getYearend()
	{
		return yearend;
	}

	public void setYearend(int yearend)
	{
		this.yearend = yearend;
	}
	
}
