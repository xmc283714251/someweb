package com.someweb.common.bean;


/**
 * 用户登录信息
 * @author mingchun.xiong
 *
 */
public class LoginInfo extends BaseBean
{

	/**
	 * serialVersionUID
	 */
	private static final long	serialVersionUID	= 1499620982760444438L;
	
	private String userid;
	
	private String username;
	
	private String password;
	
	private String realname;
	
	private String email;
	
	private String phone;
	
	private String isvalid;
	
	private String createdate;

	private String orgid;
	
	private String orgcode;
	
	private String orgname;
	
	private String parentcode;
	
	private String orgjc;

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
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

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getIsvalid()
	{
		return isvalid;
	}

	public void setIsvalid(String isvalid)
	{
		this.isvalid = isvalid;
	}

	public String getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(String createdate)
	{
		this.createdate = createdate;
	}

	public String getOrgid()
	{
		return orgid;
	}

	public void setOrgid(String orgid)
	{
		this.orgid = orgid;
	}

	public String getOrgcode()
	{
		return orgcode;
	}

	public void setOrgcode(String orgcode)
	{
		this.orgcode = orgcode;
	}

	public String getOrgname()
	{
		return orgname;
	}

	public void setOrgname(String orgname)
	{
		this.orgname = orgname;
	}

	public String getParentcode()
	{
		return parentcode;
	}

	public void setParentcode(String parentcode)
	{
		this.parentcode = parentcode;
	}

	public String getOrgjc()
	{
		return orgjc;
	}

	public void setOrgjc(String orgjc)
	{
		this.orgjc = orgjc;
	}
}
