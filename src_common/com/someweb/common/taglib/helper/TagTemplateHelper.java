package com.someweb.common.taglib.helper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import com.someweb.common.helper.ValidateHelper;
import com.someweb.common.taglib.bean.TagPropertyBean;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TagTemplateHelper
{
	
	private static final String temp_dir = "/template";
	
	private static Configuration config = null;
	
	public static Configuration getConfiguration()
	{
		if (config != null)
		{
			return config;
		}
		else
		{
			config = new Configuration();
			config.setClassForTemplateLoading(TagTemplateHelper.class, temp_dir);
			config.setObjectWrapper(new DefaultObjectWrapper());
			config.setDateFormat("yyyy-MM-dd HH:mm:ss");
			config.setDefaultEncoding("UTF-8");
		}
		return config;
	}
	
	public static Template getTemplate(String filename) throws IOException
	{
		return getConfiguration().getTemplate(filename, "UTF-8");
	}
	
	public static void converTagPropertyToBean(Object object, TagPropertyBean bean)
	{
		try
		{
			Map<String, Object> root = bean.getRoot();
			//root.clear();
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			if (ValidateHelper.isNotEmptyArray(pds))
			{
				for (PropertyDescriptor pd : pds)
				{
					Method readmethod = pd.getReadMethod();
					if (readmethod != null && !"previousOut".equals(pd.getName()))
					{
						Object value = pd.getReadMethod().invoke(object);
						root.put(pd.getName(), value);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
