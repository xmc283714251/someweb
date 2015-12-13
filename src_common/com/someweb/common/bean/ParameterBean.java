package com.someweb.common.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.someweb.common.helper.JSONHelper;

public class ParameterBean extends BaseBean
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6899441402922497396L;
	
	private List<FileUploadBean> uploadFiles = new ArrayList<FileUploadBean>();
	
	private String jsonParameters;
	
	public <T> T getParameter(Class<T> clazz)
	{
		return JSONHelper.decode(jsonParameters, clazz);
	}
	
	public Map<String,Object> getParameterMap()
	{
		return JSONHelper.decode(jsonParameters);
	}

	public List<FileUploadBean> getUploadFiles()
	{
		return uploadFiles;
	}

	public void setUploadFiles(List<FileUploadBean> uploadFiles)
	{
		this.uploadFiles = uploadFiles;
	}

	public String getJsonParameters()
	{
		return jsonParameters;
	}

	public void setJsonParameters(String jsonParameters)
	{
		this.jsonParameters = jsonParameters;
	}
	
	
}
