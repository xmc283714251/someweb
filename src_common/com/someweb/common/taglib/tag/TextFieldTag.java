package com.someweb.common.taglib.tag;

import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

public class TextFieldTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 882368716291832873L;
	private String id;
	private String name;
	private String value;
	private String type = "text"; //password,date
	private String label;
	private String cssClass = "";
	private boolean required = false;	//required
	private boolean isEmail = false;	//email
	private boolean isPhone = false;	//phone
	private boolean isAlphanumeric = false;//alphanumeric
	private boolean isDigits = false;//整数 digits
	private boolean isNumber = false;//浮点数 number
	private boolean isCreditcard =false;//信用卡 creditcard
	private boolean isLettersonly = false; //只是字母 lettersonly
	private boolean isUrl = false;	//是网址 url
	private int minlength;
	private int maxlength;
	private int equalto; //ID
	private String min;	//最小值
	private String max;//最大值
	private String alt;//错误提示
	private String tipinfo;
	private String remote;
	private boolean readonly = false;
	private boolean disabled = false;
	@Override
	public String getStartTempFileName()
	{
		return "textfield_start.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return "textfield_end.ftl";
	}

	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		TagTemplateHelper.converTagPropertyToBean(this, bean);
		StringBuffer classsb = new StringBuffer();
		if (required)
		{
			classsb.append("required ");
		}
		if (isEmail)
		{
			classsb.append("email ");
		}
		if (isPhone)
		{
			classsb.append("phone ");
		}
		if (isAlphanumeric)
		{
			classsb.append("alphanumeric ");
		}
		if (isDigits)
		{
			classsb.append("digits ");
		}
		if (isNumber)
		{
			classsb.append("number ");
		}
		if (isCreditcard)
		{
			classsb.append("creditcard ");
		}
		if (isLettersonly)
		{
			classsb.append("lettersonly");
		}
		if (isUrl)
		{
			classsb.append("url ");
		}
		if (readonly)
		{
			bean.getRoot().put("readonly", "true");
		}
		else
		{
			bean.getRoot().put("readonly", "false");
		}
		if (disabled)
		{
			bean.getRoot().put("disabled", "true");
		}
		else
		{
			bean.getRoot().put("disabled", "false");
		}
		bean.getRoot().put("cssClass", classsb.toString());
		
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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCssClass()
	{
		return cssClass;
	}

	public void setCssClass(String cssClass)
	{
		this.cssClass = cssClass;
	}

	public boolean getRequired()
	{
		return required;
	}

	public void setRequired(boolean required)
	{
		this.required = required;
	}

	public boolean getIsEmail()
	{
		return isEmail;
	}

	public void setIsEmail(boolean isEmail)
	{
		this.isEmail = isEmail;
	}

	public boolean getIsPhone()
	{
		return isPhone;
	}

	public void setIsPhone(boolean isPhone)
	{
		this.isPhone = isPhone;
	}

	public boolean getIsAlphanumeric()
	{
		return isAlphanumeric;
	}

	public void setIsAlphanumeric(boolean isAlphanumeric)
	{
		this.isAlphanumeric = isAlphanumeric;
	}

	public boolean getIsDigits()
	{
		return isDigits;
	}

	public void setIsDigits(boolean isDigits)
	{
		this.isDigits = isDigits;
	}

	public boolean getIsNumber()
	{
		return isNumber;
	}

	public void setIsNumber(boolean isNumber)
	{
		this.isNumber = isNumber;
	}

	public boolean setIsCreditcard()
	{
		return isCreditcard;
	}

	public void setIsCreditcard(boolean isCreditcard)
	{
		this.isCreditcard = isCreditcard;
	}

	public boolean getIsLettersonly()
	{
		return isLettersonly;
	}

	public void setIsLettersonly(boolean isLettersonly)
	{
		this.isLettersonly = isLettersonly;
	}

	public boolean getIsUrl()
	{
		return isUrl;
	}

	public void setIsUrl(boolean isUrl)
	{
		this.isUrl = isUrl;
	}

	public int getMinlength()
	{
		return minlength;
	}

	public void setMinlength(int minlength)
	{
		this.minlength = minlength;
	}

	public int getMaxlength()
	{
		return maxlength;
	}

	public void setMaxlength(int maxlength)
	{
		this.maxlength = maxlength;
	}

	public int getEqualto()
	{
		return equalto;
	}

	public void setEqualto(int equalto)
	{
		this.equalto = equalto;
	}

	public String getMin()
	{
		return min;
	}

	public void setMin(String min)
	{
		this.min = min;
	}

	public String getMax()
	{
		return max;
	}

	public void setMax(String max)
	{
		this.max = max;
	}

	public String getAlt()
	{
		return alt;
	}

	public void setAlt(String alt)
	{
		this.alt = alt;
	}

	public String getRemote()
	{
		return remote;
	}

	public void setRemote(String remote)
	{
		this.remote = remote;
	}

	public boolean isReadonly()
	{
		return readonly;
	}

	public void setReadonly(boolean readonly)
	{
		this.readonly = readonly;
	}

	public boolean isDisabled()
	{
		return disabled;
	}

	public void setDisabled(boolean disabled)
	{
		this.disabled = disabled;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getTipinfo()
	{
		return tipinfo;
	}

	public void setTipinfo(String tipinfo)
	{
		this.tipinfo = tipinfo;
	}

	
}
