package com.someweb.common.bean;

/**
 * 系统参数对象
 * @author mingchun.xiong
 *
 */
public class SystemParameterBean extends BaseBean
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 8856451184835996553L;
	private String id;
	
	private String proKey;
	
	private String proValue;
	
	private String descr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProKey() {
		return proKey;
	}

	public void setProKey(String proKey) {
		this.proKey = proKey;
	}

	public String getProValue() {
		return proValue;
	}

	public void setProValue(String proValue) {
		this.proValue = proValue;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
}
