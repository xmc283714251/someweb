package com.someweb.common.bean;

import java.io.File;

public class FileUploadBean extends BaseBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6678552804449162777L;

	//上传文件表达属性name
	private String name;
	
	//上传文件文件名
	private String fileName;
	
	//上传文件后缀
	private String fileSuffix;
	
	//临时文件路径
	private String tempPath;
	
	//文件类型
	private String contentType;
	
	private File file;

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public String getTempPath()
	{
		return tempPath;
	}

	public void setTempPath(String tempPath)
	{
		this.tempPath = tempPath;
	}

	public String getFileSuffix()
	{
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix)
	{
		this.fileSuffix = fileSuffix;
	}
	
}
