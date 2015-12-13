package com.someweb.common.helper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * JSON对象处理工具类
 *com.someweb.common.helper
 * @author 熊明春
 * 2015-12-12
 */
public class JSONHelper
{
	/**
	 * 转换对象为JSON字符串
	 * @param obj
	 * @return String
	 * @author 熊明春
	 * @date 2015-12-11上午12:48:44
	 */
	public static String encode(Object obj) 
	{
		if(obj == null || obj.toString().equals("null")) return null;
		if(obj != null && obj.getClass() == String.class)
		{
			return obj.toString();
		}
		JSONSerializer serializer = new JSONSerializer();
		serializer.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"), Date.class);
		serializer.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"), Timestamp.class);
		return serializer.deepSerialize(obj);
	}
	
	/**
	 * 转换JSON字符串为对象
	 * @param json
	 * @param clazz
	 * @return T
	 * @author 熊明春
	 * @date 2015-12-11上午12:48:27
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T decode(String json,Class<T> clazz) 
	{
		if (ValidateHelper.isEmptyString(json)) 
		{
			return null;
		}
		JSONDeserializer deserializer = new JSONDeserializer();
		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd"));		
		Object obj = deserializer.deserialize(json,clazz);
		return (T)obj;
	}
	
	/**
	 * 
	 * @param json
	 * @return Map<String,String>
	 * @author 熊明春
	 * @date 2015-12-12下午12:39:34
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> decode(String json)
	{
		if (ValidateHelper.isEmptyString(json)) 
		{
			return null;
		}
		JSONDeserializer deserializer = new JSONDeserializer();
		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd"));		
		Object obj = deserializer.deserialize(json);
		return (Map<String, Object>)obj;
	}
	
	public static void main(String[] args)
	{
		System.out.println(encode(true));
	}
}
