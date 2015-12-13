package com.someweb.common.config;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * 文件上传重命名类
 *com.someweb.common.config
 * @author 熊明春
 * 2015-12-12
 */
public class UploadFileReNamePolicy implements FileRenamePolicy
{

	@Override
	public File rename(File file)
	{
		String name = "";
		String ext = "";
		//取得文件名和后缀分割点
		int pot = file.getName().lastIndexOf(".");
		//不等以-1,说明后缀存在
		if (pot != -1) 
		{  
			//采用UUID的形式命名
			name =UUID.randomUUID().toString() + "";
			//截取后缀名
            ext = file.getName().substring(pot);  
        }
		//后缀不存在
		else
		{  
			name =UUID.randomUUID().toString();
        } 
		String newName = name + ext;
		//对文件进行重命名
        file = new File(file.getParent(), newName);  
        return file;  
	}

}
