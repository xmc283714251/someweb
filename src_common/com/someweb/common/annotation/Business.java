package com.someweb.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * action 控制类中的业务处理方法
 * @author xmc
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Business
{
	/**
	 * 业务处理控制名称描述
	 * @return
	 */
	public String name(); 
}
