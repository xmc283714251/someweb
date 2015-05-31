package com.someweb.common.taglib.tag;

import com.someweb.common.bean.PagerFormBean;
import com.someweb.common.taglib.bean.TagPropertyBean;
import com.someweb.common.taglib.helper.TagTemplateHelper;

/**
 * 分页生成器代标签类
 * com.someweb.common.taglib.tag
 * @author 熊明春
 * 2015-5-30
 */
public class PaginationTag extends BaseBodyTagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4261430829108954978L;
	
	private String id;
	//navTab或dialog，用来标记是navTab上的分页还是dialog上的分页
	private String targetType; 
	
	// 总条数
	private int totalCount = 0;
	
	//每页显示多少条
	private int numPerPage=20;
	
	//页标数字多少个
	private int pageNumShown = 10;
	
	private int[] pageModels = {10,20,30,40,50,60,70,80,90,100};
	
	//当前是第几页
	private int currentPage =1;
	
	private String rel;
	
	private String autoLoad = "false";
	
	@Override
	public String getStartTempFileName()
	{
		return "pagination.ftl";
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
		PagerFormBean formBean = (PagerFormBean)pageContext.getRequest().getAttribute("pagerForm");
		if (formBean != null)
		{
			bean.getRoot().put("totalCount", formBean.getTotalCount());
			bean.getRoot().put("numPerPage", formBean.getNumPerPage());
			bean.getRoot().put("pageNumShown", formBean.getPageNumShown());
			bean.getRoot().put("currentPage", formBean.getPageNum());
			bean.getRoot().put("totalPage", formBean.getTotalPage());
		}
	}

	public String getTargetType()
	{
		return targetType;
	}

	public void setTargetType(String targetType)
	{
		this.targetType = targetType;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getNumPerPage()
	{
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage)
	{
		this.numPerPage = numPerPage;
	}

	public int getPageNumShown()
	{
		return pageNumShown;
	}

	public void setPageNumShown(int pageNumShown)
	{
		this.pageNumShown = pageNumShown;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public String getRel()
	{
		return rel;
	}

	public void setRel(String rel)
	{
		this.rel = rel;
	}

	public String getAutoLoad()
	{
		return autoLoad;
	}

	public void setAutoLoad(String autoLoad)
	{
		this.autoLoad = autoLoad;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int[] getPageModels()
	{
		return pageModels;
	}

	public void setPageModels(int[] pageModels)
	{
		this.pageModels = pageModels;
	}
	
}
