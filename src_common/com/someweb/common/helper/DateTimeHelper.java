package com.someweb.common.helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *  时间帮助类
 * @author mingchun.xiong
 *
 */
public final class DateTimeHelper {
	
	/**
	 * 获取系统当期时间
	 * @return
	 */
	public static Timestamp getNowTimestamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * 系统当期时间
	 * @return
	 */
	public static Date getNowDate()
	{
		return new Date(System.currentTimeMillis());
	}
	
	/**
	 * 获取当期时间字符串
	 * @param pattern
	 * @return
	 */
	public static String getNowDateStr(String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * 时间转化
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Timestamp convertToTimestamp(String dateStr,String pattern)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date date = sdf.parse(dateStr);
			return new Timestamp(date.getTime());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String converToStr(long timeMillis, String pattern)
	{
		Timestamp t = new Timestamp(timeMillis);
		return convert(t, pattern);
	}
	
	/**
	 * 时间转化
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date convertToDate(String dateStr, String pattern)
	{
		if (ValidateHelper.isNotEmptyString(dateStr))
		{
			try
			{
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				return sdf.parse(dateStr);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 时间转化
	 * @param timestamp
	 * @param pattern
	 * @return
	 */
	public static String convert(Timestamp timestamp, String pattern)
	{
		if (timestamp == null)
		{
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}
	
	/**
	 * 时间转化
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String conver(Date date, String pattern)
	{
		if (date == null)
		{
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date addDateTime(long currentmi, int day)
	{
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(currentmi);
		cl.add(Calendar.DATE, day);
		return new Date(cl.getTimeInMillis());
	}
	
	/**
	 * 给时间增加一定天数
	 * @param currentmi 
	 * @param day 增加的天数
	 * @param pattern
	 * @return
	 */
	public static String addDateTimeToStr(long currentmi, int day,String pattern)
	{
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(currentmi);
		cl.add(Calendar.DATE, day);
		long result = cl.getTimeInMillis();
		return conver(new Date(result), pattern);
	}
	
	public static String converTimeToStr(long time, String pattern)
	{
		return conver(new Date(time), pattern);
	}
	
	/**
	 * 获取当前日期的第一天
	 * @return
	 */
	public static Timestamp getFirstDayOfMonth()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
		return new Timestamp(cal.getTime().getTime());
	}
	
	/**
	 * 获取当月的最后一天
	 * @return
	 */
	public static Timestamp getLastDayOfMonth()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);  
		cal.roll(Calendar.DATE, -1);  
		return new Timestamp(cal.getTime().getTime());
	}
	
	public static Date addMonths(Date date,int i)
	{
		return addDateTime(date.getTime(), i * 31);
	}
	
	public static Date addYears(Date date, int i)
	{
		return addDateTime(date.getTime(), i * 365);
	}
	
	public static void main(String[] args)
	{
		System.out.println(conver(addYears(new Date(), 3),"yyyy-MM-dd"));
	}
}
