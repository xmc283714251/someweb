package com.someweb.common.business;

import com.frameworkset.common.poolman.SQLExecutor;
import com.someweb.common.bean.LoginInfo;
import com.someweb.common.constant.CommonConstant;

public class LoginBusiness
{
	/**
	 * 根据用户名和密码获取用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginInfo queryLoginInfoByUserNameAndPassword(String username, String password)
	{
		LoginInfo loginInfo = null;
		String sql = " select u.userid,u.username,u.password,u.realname,u.email,u.phone,u.isvalid,u.createdate,  o.orgid,o.orgcode,o.orgname,o.parentid,o.orgjc" +
					" from td_common_user u inner join td_common_orguser ou on u.userid=ou.userid" + 
				    " inner join td_common_organization o on o.orgid=ou.orgid" +
					" where username=? and password=? and u.isvalid='1'";
		try
		{
			loginInfo = SQLExecutor.queryObjectWithDBName(LoginInfo.class, CommonConstant.DBNAME_COMMON, sql, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return loginInfo;
	}
}
