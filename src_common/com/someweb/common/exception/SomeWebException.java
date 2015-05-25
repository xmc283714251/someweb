package com.someweb.common.exception;

public class SomeWebException extends Exception
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -830178666551443465L;
	
	private String errorCode;
	
	public SomeWebException()
	{
		super();
	}

	public SomeWebException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SomeWebException(String message)
	{
		super(message);
	}
	
	public SomeWebException(String errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	
}
