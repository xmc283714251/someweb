package com.someweb.common.bean;

/**
 * 业务对象bean
 *com.someweb.common.bean
 * @author 熊明春
 * 2015-12-13
 */
public class BusinessBean
{
	//ID
	private String id;
	//对象类
	private String classname;
	//对象类class
	private Class<?> clazz;
	
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getClassname()
	{
		return classname;
	}
	public void setClassname(String classname)
	{
		this.classname = classname;
	}
	public Class<?> getClazz()
	{
		return clazz;
	}
	public void setClazz(Class<?> clazz)
	{
		this.clazz = clazz;
	}
	
	
}
