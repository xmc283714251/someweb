package com.someweb.common.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置文件控制对象
 *com.someweb.common.bean
 * @author 熊明春
 * 2015-12-12
 */
public class ControllerBean
{
	//业务逻辑ID
	private String id;
	
	//类名称
	private String className;
	
	private Class<?> clazz;
	
	//逻辑结果对象
	private Map<String,LogicResultBean> resultMap = new HashMap<String,LogicResultBean>();
	
	//属性逻辑对象
	private Map<String,PropertyBean> propertyMap = new HashMap<String,PropertyBean>();
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public Map<String, LogicResultBean> getResultMap()
	{
		return resultMap;
	}
	public void setResultMap(Map<String, LogicResultBean> resultMap)
	{
		this.resultMap = resultMap;
	}
	public Class<?> getClazz()
	{
		return clazz;
	}
	public void setClazz(Class<?> clazz)
	{
		this.clazz = clazz;
	}
	public Map<String, PropertyBean> getPropertyMap()
	{
		return propertyMap;
	}
	public void setPropertyMap(Map<String, PropertyBean> propertyMap)
	{
		this.propertyMap = propertyMap;
	}
	
	
}
