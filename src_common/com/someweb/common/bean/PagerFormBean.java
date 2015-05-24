package com.someweb.common.bean;

/**
 * 分页标签数据封装对象
 * @author mc
 *
 */
public class PagerFormBean extends BaseBean
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2604953718766092085L;
	
	/**
	 * 当前页
	 */
	private int pageNum = 1;
	
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	/**
	 * 每页显示多少条
	 */
	private int numPerPage = 20;
	
	/**
	 * 总条数
	 */
	private int totalCount;
	
	/**
	 * 页标数字多少个
	 */
	private int pageNumShown = 10;
	
	/**
	 * 排序字段
	 */
	private String orderField;
	
	/**
	 * 排序放松
	 */
	private String orderDirection;

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getNumPerPage()
	{
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage)
	{
		this.numPerPage = numPerPage;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getPageNumShown()
	{
		return pageNumShown;
	}

	public void setPageNumShown(int pageNumShown)
	{
		this.pageNumShown = pageNumShown;
	}

	public String getOrderField()
	{
		return orderField;
	}

	public void setOrderField(String orderField)
	{
		this.orderField = orderField;
	}

	public String getOrderDirection()
	{
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection)
	{
		this.orderDirection = orderDirection;
	}
	
	
}
