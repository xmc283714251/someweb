package com.someweb.common.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.frameworkset.common.poolman.DBUtil;
import com.frameworkset.common.poolman.SQLExecutor;
import com.someweb.common.bean.SystemDictionaryBean;
import com.someweb.common.bean.SystemParameterBean;
import com.someweb.common.constant.CommonConstant;

/**
 * 字典缓存初始化工具类
 * @author mingchun.xiong
 *
 */
public class DictionaryCacheHellper
{
	private static Logger log = Logger.getLogger(DictionaryCacheHellper.class);
	/**
	 * 系统参数缓存
	 */
	private static Map<String, String> parameterMap = new HashMap<String, String>();
	
	/**
	 * 	数据字典
	 */
	private static Map<String, List<SystemDictionaryBean>> dictionaryMap = new HashMap<String,List<SystemDictionaryBean>>();
	
	
	/**
	 * 初始化缓存
	 */
	public static void initCache()
	{
		parameterMap.clear();
		dictionaryMap.clear();
		//初始化系统参数
		initParameter();
		//初始化字典
		initDictionary();
		 
	}
	
	 
	
	/**
	 * 初始化系统参数
	 */
	public static void initParameter()
	{
		log.info("系统正在初始化系统参数....");
		String sql = "select id, prokey, provalue,descr from td_common_parameter";
		try
		{
			List<SystemParameterBean> list = SQLExecutor.queryListWithDBName(SystemParameterBean.class, CommonConstant.DBNAME_COMMON, sql);
			if (ValidateHelper.isNotEmptyCollection(list))
			{
				for (SystemParameterBean paramBean : list)
				{
					parameterMap.put(paramBean.getProKey(), paramBean.getProValue());
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		log.info("系统初始化系统参数结束.");
	}
	
	/**
	 * 初始化字典
	 */
	public static void initDictionary()
	{
		log.info("系统正在初始化字典...");
		try
		{
			//查询字典类别
			String queryzdlbsql = "select distinct zdlb from td_common_dictionary t where isvalid='1'";
			DBUtil util = new DBUtil();
			util.executeSelect(CommonConstant.DBNAME_COMMON, queryzdlbsql);
			for (int i=0;i<util.size();i++)
			{
				dictionaryMap.put(util.getString(i, "zdlb"), new ArrayList<SystemDictionaryBean>());
			}
			
			// 初始化字典
			String querysql = "select id, zdlb, zdmc, dm, mc, parent_dm, descr, isvalid, sn from td_common_dictionary where isvalid='1' order by sn,dm";
			List<SystemDictionaryBean> beanList = SQLExecutor.queryListWithDBName(SystemDictionaryBean.class, CommonConstant.DBNAME_COMMON, querysql);
			
			if (ValidateHelper.isNotEmptyCollection(beanList))
			{
				for (SystemDictionaryBean bean : beanList)
				{
					dictionaryMap.get(bean.getZdlb()).add(bean);
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		log.info("系统初始化字典结束.");
	}
	 
	/**
	 * 获取系统参数值
	 * @param proKey
	 * @return
	 */
	public static String getSystemParamenterValueByKey(String proKey)
	{
		return parameterMap.get(proKey);
	}
	
	/**
	 * 获取字典集合
	 * @param zdlb
	 * @return
	 */
	public static List<SystemDictionaryBean> getSystemDictionaryListByZdlb(String zdlb)
	{
		return dictionaryMap.get(zdlb);
	}
	
	/**
	 * 获取字典名称
	 * @param zdlb 字典类别
	 * @param dm 代码
	 * @return
	 */
	public static String getSystemDictionaryValueByZdlbAndDm(String zdlb, String dm)
	{
		List<SystemDictionaryBean> list = dictionaryMap.get(zdlb);
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			for (SystemDictionaryBean bean : list)
			{
				if (bean.getDm().equalsIgnoreCase(dm))
				{
					return bean.getMc();
				}
			}
		}
		return "";
	}
	
	
	/**
	 * 通过父代码获取子节点数据
	 * @param zdlb
	 * @param parentDm
	 * @return
	 */
	public static List<SystemDictionaryBean> getSystemDictionaryBeanListByParentDm(String zdlb, String parentDm)
	{
		List<SystemDictionaryBean> list = dictionaryMap.get(zdlb);
		List<SystemDictionaryBean> resultList = new ArrayList<SystemDictionaryBean>();
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			for (SystemDictionaryBean bean : list)
			{
				if (parentDm.equals(bean.getParent_dm()))
				{
					resultList.add(bean);
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 获取字典
	 * @param zdlb 字典类别
	 * @param dm 代码
	 * @return
	 */
	public static SystemDictionaryBean getSystemDictionaryBeanByZdlbAndDm(String zdlb, String dm)
	{
		List<SystemDictionaryBean> list = dictionaryMap.get(zdlb);
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			for (SystemDictionaryBean bean : list)
			{
				if (bean.getDm().equalsIgnoreCase(dm))
				{
					return bean;
				}
			}
		}
		return null;
	}
	 
}
