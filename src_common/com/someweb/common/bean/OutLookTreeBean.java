package com.someweb.common.bean;

/**
 * 功能树菜单
 * com.someweb.common.bean
 * @author 熊明春
 * 2015-12-10
 */
public class OutLookTreeBean extends BaseBean
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2248187823224954764L;
	private String funid;
	private String funtext;
	private String parentid;
	private String path;
	private String isvalid;
	private String target;
	private String sn;
	private String createdate;
	
	public String getFunid()
	{
		return funid;
	}
	public void setFunid(String funid)
	{
		this.funid = funid;
	}
	public String getFuntext()
	{
		return funtext;
	}
	public void setFuntext(String funtext)
	{
		this.funtext = funtext;
	}
	public String getParentid()
	{
		return parentid;
	}
	public void setParentid(String parentid)
	{
		this.parentid = parentid;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getIsvalid()
	{
		return isvalid;
	}
	public void setIsvalid(String isvalid)
	{
		this.isvalid = isvalid;
	}
	public String getTarget()
	{
		return target;
	}
	public void setTarget(String target)
	{
		this.target = target;
	}
	public String getSn()
	{
		return sn;
	}
	public void setSn(String sn)
	{
		this.sn = sn;
	}
	public String getCreatedate()
	{
		return createdate;
	}
	public void setCreatedate(String createdate)
	{
		this.createdate = createdate;
	}
	
	
}
