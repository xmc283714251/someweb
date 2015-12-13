package com.someweb.test.action;

public class LJBBean
{
	private String code;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
	
	public void save(){}
	
	public boolean isYes(){return false;}
	
	public int reutnrInt(){return 0;}
	
	public String reutnrString(){return "";}
	
	public Boolean reutnrBoolean(){return null;}
	
	public LJBBean returnLJBBean(){return null;}
	
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException
	{
		System.out.println(LJBBean.class.getMethod("save").getReturnType().getSimpleName().toString());
		System.out.println(LJBBean.class.getMethod("isYes").getReturnType().getSimpleName().toString());
		System.out.println(LJBBean.class.getMethod("reutnrInt").getReturnType().getSimpleName().toString());
		System.out.println(LJBBean.class.getMethod("returnLJBBean").getReturnType().getSimpleName().toString());
		System.out.println(LJBBean.class.getMethod("reutnrString").getReturnType().getSimpleName().toString());
		System.out.println(LJBBean.class.getMethod("reutnrBoolean").getReturnType().getSimpleName().toString());
	}
}
