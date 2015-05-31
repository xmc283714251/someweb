package com.someweb.common.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 分页查询结构返回对象集
 * @author 熊明处
 *
 */
public class PageResultInfo<T> extends BaseBean{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6637970201050479811L;

	//当前页
	private int currentPage = 1;
	
	//分页查询
	private int pageSize = 10;
	
	//总页数
	private long totalPage = 1;
	
	//总记录数
	private long totalCount = 0;
	
	//数据结果集
	private List<T> datas = new ArrayList<T>();
	
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalPage() {

		if (totalCount<=pageSize)
		{
			totalPage = 1;
		}
		else if (totalCount%pageSize == 0)
		{
			totalPage = totalCount/pageSize;
		}
		else if (totalCount%pageSize > 0)
		{
			return (totalCount/pageSize) + 1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public void addData(T t)
	{
		datas.add(t);
	}
	
	
}
