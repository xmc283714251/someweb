package com.someweb.common.helper;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class PropertyDescriptorHelper
{
	/**
	 * 获取对象的 PropertyDescriptor 对象
	 * @param clazz
	 * @param propertyName
	 * @return
	 * @throws IntrospectionException PropertyDescriptor
	 * @author 熊明春
	 * @date 2015-12-13下午9:37:40
	 */
	public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz,String propertyName) throws IntrospectionException
	{
		return new PropertyDescriptor(propertyName,clazz);
	}
	
	/**
	 * 获取对象的所有 PropertyDescriptor属性
	 * @param clazz
	 * @return
	 * @throws IntrospectionException PropertyDescriptor[]
	 * @author 熊明春
	 * @date 2015-12-13下午9:40:13
	 */
	public static PropertyDescriptor[] getPropertyDescriptorArray(Class<?> clazz) throws IntrospectionException
	{
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz,Introspector.USE_ALL_BEANINFO);
		return beanInfo.getPropertyDescriptors();
	}
	
	/**
	 * 调用写方法
	 * @param object
	 * @param propertyName
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException void
	 * @author 熊明春
	 * @date 2015-12-13下午9:48:33
	 */
	public static void invokeWriteMethod(Object object,String propertyName, Object ... args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException
	{
		PropertyDescriptor propertyDesriptor = new PropertyDescriptor(propertyName,object.getClass());
		propertyDesriptor.getWriteMethod().invoke(object, args);
	}
	
	/**
	 * 调用读方法
	 * @param object
	 * @param propertyName
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException void
	 * @author 熊明春
	 * @date 2015-12-13下午9:48:17
	 */
	public static void invokeReadMethod(Object object,String propertyName) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
	{
		PropertyDescriptor propertyDesriptor = new PropertyDescriptor(propertyName,object.getClass());
		propertyDesriptor.getReadMethod().invoke(object);
	}
}
