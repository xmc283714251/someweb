package com.someweb.common.action;

import com.someweb.common.bean.LoginInfo;
import com.someweb.common.business.LoginBusiness;
import com.someweb.common.constant.CommonConstant;
import com.someweb.common.helper.ActionContextHelper;
import com.someweb.common.listener.SessionCounterListener;

/**
 * 系统登录Action
 * @author xmc
 *
 */
public class LoginAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763111082628911361L;
	
	private LoginBusiness loginBusiness;
	
	private String username;
	private String password;
	
	public LoginAction()
	{
		super();
		loginBusiness = new LoginBusiness();
	}
	
	/**
	 * 进入主页
	 * @return
	 */
	public String index()
	{
		return "index";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login()
	{
		LoginInfo loginInfo = loginBusiness.queryLoginInfoByUserNameAndPassword(username, password);
		//存放到当前回话中
		if (loginInfo != null)
		{
			ActionContextHelper.setLoginInfo(loginInfo);
			return "loginSuccess";
		}
		else
		{
			return "loginOut";
		}
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String logout()
	{
		session.removeAttribute(CommonConstant.LOGIN_INFO);
		SessionCounterListener.inlineNum--;
		session.setAttribute(CommonConstant.CURRENT_INLINE_NUM, SessionCounterListener.inlineNum);
		return "loginOut";
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
