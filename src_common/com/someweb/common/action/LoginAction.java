package com.someweb.common.action;

import org.apache.commons.lang.StringUtils;

import com.someweb.common.annotation.Business;
import com.someweb.common.bean.LoginInfo;
import com.someweb.common.business.LoginBusiness;
import com.someweb.common.constant.CommonConstant;
import com.someweb.common.helper.ActionContextHelper;

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
	private String code;
	private String errorMsg;
	
	public LoginAction()
	{
		super();
		loginBusiness = new LoginBusiness();
	}
	
	/**
	 * 进入主页
	 * @return
	 */
	@Business(name="index")
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
		String sessionCode = (String) session.getAttribute(CommonConstant.VALIDATE_CODE);
		if (sessionCode.equalsIgnoreCase(code))
		{
			LoginInfo loginInfo = loginBusiness.queryLoginInfoByUserNameAndPassword(username, password);
			if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password))
			{
				//存放到当前回话中
				if (loginInfo != null)
				{
					ActionContextHelper.setLoginInfo(loginInfo);
					return "loginSuccess";
				}
				else
				{
					errorMsg = "用户名或密码不正确";
					return "loginOut";
				}
			}
			else
			{
				errorMsg = "用户名或密码不能为空";
				return "loginOut";
			}
		}
		else
		{
			errorMsg = "验证码不正确或不能为空";
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

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
	
}
