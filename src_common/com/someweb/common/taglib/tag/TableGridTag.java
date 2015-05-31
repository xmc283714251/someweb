package com.someweb.common.taglib.tag;

import com.someweb.common.bean.PagerFormBean;
import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 表格标签
 * com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-5-31
 */
public class TableGridTag extends PaginationTag
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2480248593329964598L;
	private String id;
	private String layoutH;
	// table or list
	private String type = "table"; 
	private String width = "100%";
	private String targetType = "navTab";
	private String usepager = "true";
	private String action;
	
	@Override
	public String getStartTempFileName()
	{
		return "tablegrid_start.ftl";
	}

	@Override
	public String getEndTempFileName()
	{
		return "tablegrid_end.ftl";
	}

	@Override
	public void setTagPropertyBean(TagPropertyBean bean)
	{
		super.setTagPropertyBean(bean);
		TagTemplateHelper.converTagPropertyToBean(this, bean);
		PagerFormBean formBean = (PagerFormBean)pageContext.getRequest().getAttribute("pagerForm");
		if (formBean != null)
		{
			bean.getRoot().put("totalCount", formBean.getTotalCount());
			bean.getRoot().put("numPerPage", formBean.getNumPerPage());
			bean.getRoot().put("pageNumShown", formBean.getPageNumShown());
			bean.getRoot().put("currentPage", formBean.getPageNum());
			bean.getRoot().put("totalPage", formBean.getTotalPage());
			bean.getRoot().put("orderField", formBean.getOrderField());
			bean.getRoot().put("orderDirection", formBean.getOrderDirection());
		}
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getLayoutH()
	{
		return layoutH;
	}

	public void setLayoutH(String layoutH)
	{
		this.layoutH = layoutH;
	}

	public String getWidth()
	{
		return width;
	}

	public void setWidth(String width)
	{
		this.width = width;
	}

	public String getTargetType()
	{
		return targetType;
	}

	public void setTargetType(String targetType)
	{
		this.targetType = targetType;
	}

	public String getUsepager()
	{
		return usepager;
	}

	public void setUsepager(String usepager)
	{
		this.usepager = usepager;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}
