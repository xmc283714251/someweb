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
	
	private String realnamepy;
	
	private String moblie;
	
	private String telephone;
	
	private String sfzh;
	
	private String isvalid;
	
	private String createdate;

	private String orgid;
	
	private String orgcode;
	
	private String orgname;
	
	private String parent_code;
	
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

	public String getRealnamepy()
	{
		return realnamepy;
	}

	public void setRealnamepy(String realnamepy)
	{
		this.realnamepy = realnamepy;
	}

	public String getMoblie()
	{
		return moblie;
	}

	public void setMoblie(String moblie)
	{
		this.moblie = moblie;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getSfzh()
	{
		return sfzh;
	}

	public void setSfzh(String sfzh)
	{
		this.sfzh = sfzh;
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

	public String getParent_code()
	{
		return parent_code;
	}

	public void setParent_code(String parent_code)
	{
		this.parent_code = parent_code;
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
