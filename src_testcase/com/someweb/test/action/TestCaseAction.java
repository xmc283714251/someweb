package com.someweb.test.action;

import com.someweb.common.action.BaseAction;
import com.someweb.common.bean.LoginInfo;
import com.someweb.common.bean.PageResultInfo;

public class TestCaseAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4046264880620975451L;
	
	public void queryTestTableGridData()
	{
		PageResultInfo<LoginInfo> pageResultInfo = new PageResultInfo<LoginInfo>();
		int currentPage = getPagerForm().getPageNum();
		int pageSize = getPagerForm().getNumPerPage();
		pageResultInfo.setCurrentPage(currentPage);
		pageResultInfo.setPageSize(pageSize);
		pageResultInfo.setTotalCount(110);
		LoginInfo loginInfo = null;
		for (int i=(currentPage-1 * pageSize);i<(currentPage-1 * pageSize) + 20;i++)
		{
			loginInfo = new LoginInfo();
			loginInfo.setUserid(i + "");
			loginInfo.setUsername("username_" + i);
			loginInfo.setRealname("xmc_" + i);
			loginInfo.setCreatedate("2015-05-31");
			loginInfo.setEmail("283714251@qq.com");
			loginInfo.setPhone("15873131237");
			pageResultInfo.getDatas().add(loginInfo);
		}
	}
}
