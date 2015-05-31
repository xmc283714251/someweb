package com.someweb.common.taglib.tag;

import com.someweb.common.bean.PagerFormBean;
import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 分页pagerform表单生产器
 *com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-5-30
 */
public class PagerFormTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4837992087248577500L;
	
	//主键
	private String id = "pagerForm";
	//分页form 对象的action
	private String action;
	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		TagTemplateHelper.converTagPropertyToBean(this, bean);
		PagerFormBean formBean = (PagerFormBean)pageContext.getRequest().getAttribute("pagerForm");
		if (formBean != null)
		{
			bean.getRoot().put("numPerPage", formBean.getNumPerPage());
			bean.getRoot().put("orderField", formBean.getOrderField());
			bean.getRoot().put("orderDirection", formBean.getOrderDirection());
		}
	}
	
	@Override
	public String getStartTempFileName()
	{
		return "pageform_start.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return "pageform_end.ftl";
	}

	

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}
	
	
}
