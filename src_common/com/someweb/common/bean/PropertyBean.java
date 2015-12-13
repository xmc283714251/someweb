package com.someweb.common.bean;

/**
 * controller配置文件的property节点
 *com.someweb.common.bean
 * @author 熊明春
 * 2015-12-13
 */
public class PropertyBean
{
	private String name;
	
	private String ref;

	public String getRef()
	{
		return ref;
	}

	public void setRef(String ref)
	{
		this.ref = ref;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
