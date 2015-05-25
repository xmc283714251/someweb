package com.someweb.common.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.frameworkset.common.poolman.DBUtil;
import com.frameworkset.common.poolman.SQLExecutor;
import com.someweb.common.bean.LoginInfo;
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
		
		initParameter();
		
		initDictionary();
		 
	}
	
	 
	
	/**
	 * 初始化系统参数
	 */
	public static void initParameter()
	{
		String sql = "select id, prokey, provalue,descr from t_common_parameter";
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
	}
	
	/**
	 * 初始化字典
	 */
	public static void initDictionary()
	{
		try
		{
			//查询字典类别
			String queryzdlbsql = "select distinct zdlb from t_common_dictionary t where isyx='1'";
			DBUtil util = new DBUtil();
			util.executeSelect(CommonConstant.DBNAME_COMMON, queryzdlbsql);
			for (int i=0;i<util.size();i++)
			{
				dictionaryMap.put(util.getString(i, "zdlb"), new ArrayList<SystemDictionaryBean>());
			}
			
			// 初始化字典
			String querysql = "select id, zdlb, zdmc, dm, mc, parent_dm, jc, isyx, sn from t_common_dictionary where isyx='1' order by sn,dm";
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
	
	public static List<SystemDictionaryBean> getSystemDictionaryListByZdlbAndOnLevel(String zdlb)
	{
		List<SystemDictionaryBean> newlist = new ArrayList<SystemDictionaryBean>();
		List<SystemDictionaryBean> list = dictionaryMap.get(zdlb);
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			for (SystemDictionaryBean bean : list)
			{
				if ("0".equals(bean.getParent_dm()))
				{
					newlist.add(bean);
				}
			}
		}
		return newlist;
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
	 * 通过级别获取字典数据
	 * @param zdlb 字典类别
	 * @param leve 级别层级
	 * @return
	 * @date 2013-8-7 下午04:02:46
	 */
	public static List<SystemDictionaryBean> getSystemDictionaryBeanListByLevel(String zdlb, String leve)
	{
		List<SystemDictionaryBean> list = dictionaryMap.get(zdlb);
		List<SystemDictionaryBean> resultList = new ArrayList<SystemDictionaryBean>();
		if (ValidateHelper.isNotEmptyCollection(list))
		{
			for (SystemDictionaryBean bean : list)
			{
				if (leve.equals(bean.getLeve()))
				{
					resultList.add(bean);
				}
			}
		}
		return resultList;
	}
	
	
	/**
	 * 初始化自定义字典
	 */
	public static void initDmDictionary()
	{
		try
		{
			//查询字典类别
			String queryzdlbsql = "select distinct zdlb from t_common_dm_dictionary t where isyx='1'";
			DBUtil util = new DBUtil();
			util.executeSelect(CommonConstant.DBNAME_COMMON, queryzdlbsql);
			for (int i=0;i<util.size();i++)
			{
				dictionaryMap.put(util.getString(i, "zdlb"), new ArrayList<SystemDictionaryBean>());
			}
			
			// 初始化字典
			String querysql = "select id, zdlb, zdmc, dm, mc, parent_dm, jc, isyx, sn from t_common_dm_dictionary where isyx='1' order by sn,dm";
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
	}
	
	 
	
	/**
	 * 查询派出所通过县区公安机关机构代码
	 * @param parentcode 市级机构代码
	 * @return
	 * @date 2013-10-24 上午09:17:17
	 */
	public static List<SystemDictionaryBean> queryPcsGajgjgdws(String parentcode)
	{
		List<SystemDictionaryBean> list = null;
		try
		{
			String sql = "select orgid as id,orgcode as dm,orgname as mc ,parent_code as parent_dm,orgjc as jc,'4' as leve  " +
					"from v_common_organization t  " +
					"where t.PARENT_CODE=? " +
					"and substr(t.orgcode,9,4)='0000'  " +
					"and ispcs='1' " +
					"and isyx='1' " +
					"order by t.orgcode";
			list = SQLExecutor.queryListWithDBName(SystemDictionaryBean.class, CommonConstant.DBNAME_COMMON, sql, parentcode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询可访问派出所通过县区公安机关机构代码
	 * @param parentcode 市级机构代码
	 * @return
	 * @date 2013-10-24 上午09:17:17
	 */
	public static List<SystemDictionaryBean> queryKfwPcsGajgjgdws(String parentcode)
	{
		List<SystemDictionaryBean> list = null;
		try
		{
			LoginInfo login = ActionContextHelper.getLoginInfo();
			String userId = login.getUserid();
			
			String sql = "select orgid as id,orgcode as dm,orgname as mc ,parent_code as parent_dm,orgjc as jc,'4' as leve  " +
					"from v_common_organization t  " +
					"where t.PARENT_CODE=? " +
					"and substr(t.orgcode,9,4)='0000'  " +
					"and ispcs='1' " +
					"and isyx='1' " +
					" and orgid in (select org_id from cs_jz_ptgl.v_tb_res_org_user_write where user_id = '" + userId + "' ) " +
					"order by t.orgcode";
			list = SQLExecutor.queryListWithDBName(SystemDictionaryBean.class, CommonConstant.DBNAME_COMMON, sql, parentcode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询派出所警务室
	 * @param parentcode 派出所代码
	 * @return
	 * @date 2013-10-24 上午09:16:54
	 */
	public static List<SystemDictionaryBean> queryJwsGajgjgdws(String parentcode)
	{
		List<SystemDictionaryBean> list = null;
		try
		{
			String sql = "select orgid as id,orgcode as dm,orgname as mc ,parent_code as parent_dm,orgjc as jc,'5' as leve  " +
					"from v_common_organization t  " +
					" where t.PARENT_CODE=substr(?,1,8)||'3100' " +
					"order by t.orgcode";
			list = SQLExecutor.queryListWithDBName(SystemDictionaryBean.class, CommonConstant.DBNAME_COMMON, sql, parentcode);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
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
