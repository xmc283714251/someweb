package com.someweb.common.helper;

import java.util.ArrayList;
import java.util.List;

public class StringArrayListHelper
{
	public static String converStringArrayToStr(String[] arr, String split)
	{
		StringBuffer sb = new StringBuffer("");
		if (ValidateHelper.isNotEmptyArray(arr))
		{
			for (int i=0;i<arr.length;i++)
			{
				if (i == arr.length-1)
				{
					sb.append(arr[i].trim());
				}
				else
				{
					sb.append(arr[i].trim() + split);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 转化字符串为数组
	 * @param str
	 * @param split
	 * @return
	 * @date Jul 3, 2014 11:45:57 AM
	 */
	public static String[] converStringToStringArray(String str, String split)
	{
		if (ValidateHelper.isNotEmptyString(str))
		{
			return str.split(split);
		}
		return null;
	}
	
	/**
	 * 转化字符数组为list
	 * @param arr
	 * @return
	 * @date Jul 5, 2014 12:47:23 PM
	 */
	public static List<String> converStringArrayToList(String[] arr)
	{
		List<String> list = new ArrayList<String>();
		if (ValidateHelper.isNotEmptyArray(arr))
		{
			for (String str : arr)
			{
				list.add(str);
			}
		}
		return list;
	}
	
	public static String converListToString(List<String> list, String split)
	{
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			String[] strarr = new String[list.size()];
			strarr = list.toArray(strarr);
			return converStringArrayToStr(strarr, split);
		}
		return "";
	}
}
