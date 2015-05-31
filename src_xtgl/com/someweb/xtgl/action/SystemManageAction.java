package com.someweb.xtgl.action;

import java.util.List;

import com.someweb.common.action.BaseAction;
import com.someweb.common.bean.LoginInfo;
import com.someweb.common.bean.PageResultInfo;
import com.someweb.common.bean.PagerFormBean;

/**
 * 系统管理控制类
 * @author 熊明春
 *
 */
public class SystemManageAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 159507894012906256L;
	private List<LoginInfo> loginInfoList = null;
	private LoginInfo userBean = null;
	
	public String left()
	{
		return "xtglleft";
	}
	
	/**
	 * 调整用户管理页面
	 * @return String
	 * @author 熊明春
	 * @date 2015-5-30下午10:45:33
	 */
	public String toUserManagerPage()
	{
		PageResultInfo<LoginInfo> pageResultInfo = new PageResultInfo<LoginInfo>();
		int currentPage = getPagerForm().getPageNum();
		PagerFormBean formBean = getPagerForm();
		int pageSize = formBean.getNumPerPage();
		pageResultInfo.setCurrentPage(currentPage);
		pageResultInfo.setPageSize(pageSize);
		pageResultInfo.setTotalCount(110);
		LoginInfo loginInfo = null;
		for (int i=((currentPage-1) * pageSize);i<((currentPage-1) * pageSize) + pageSize;i++)
		{
			loginInfo = new LoginInfo();
			loginInfo.setUserid(i + "");
			if(userBean != null)
			{
				loginInfo.setUsername(userBean.getUsername()+"_" + i);
			}
			else
			{
				loginInfo.setUsername("username_" + i);
			}
			loginInfo.setRealname("xmc_" + i);
			loginInfo.setCreatedate("2015-05-31");
			loginInfo.setEmail("283714251@qq.com");
			loginInfo.setPhone("15873131237");
			pageResultInfo.getDatas().add(loginInfo);
		}
		formBean.setTotalCount((int)pageResultInfo.getTotalCount());
		loginInfoList = pageResultInfo.getDatas();
		return "toUserManagerPage";
	}

	public List<LoginInfo> getLoginInfoList()
	{
		return loginInfoList;
	}

	public void setLoginInfoList(List<LoginInfo> loginInfoList)
	{
		this.loginInfoList = loginInfoList;
	}

	public LoginInfo getUserBean()
	{
		return userBean;
	}

	public void setUserBean(LoginInfo userBean)
	{
		this.userBean = userBean;
	}
	
}
