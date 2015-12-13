package com.someweb.common.helper;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 判断对象是否是null，及 字符串是否为空字符串
 * 集合是否为空集合
 * @author mingchun.xiong
 *
 */
public final class ValidateHelper {
	
	@SuppressWarnings("unused")
	private static <T> boolean isEmptyArray(T[] array)
	{
		if (array == null || array.length == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static <T> boolean isNotEmptyArray(T[] array)
	{
		if (array != null && array.length > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isEmptyString(String string)
	{
		if (string == null || string.length() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isNotEmptyString(String string)
	{
		if (string != null && string.length() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isEmptyCollection(Collection<?> collection)
	{
		if (collection == null || collection.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static boolean isNotEmptyCollection(Collection<?> collection)
	{
		if (collection != null && !collection.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmptyMap(Map map)
	{
		if (map != null && !map.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmptyMap(Map map)
	{
		if (map == null || map.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 验证时间字符串是否满足指定格式
	 * @param datestr 时间字符串
	 * @param format 验证的时间格式串 如：yyyy-MM-dd
	 * @return boolean
	 * @author 熊明春
	 * @date 2015-12-10下午9:18:56
	 */
	public static boolean isValidDateFormat(String datestr, String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try
		{
			Date date = formatter.parse(datestr);
			return datestr.equals(formatter.format(date));
		}
		catch(Exception e)
		{
		}
		return false;
	}
 
}
