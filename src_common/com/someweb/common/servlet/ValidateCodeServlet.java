package com.someweb.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.someweb.common.constant.CommonConstant;
import com.someweb.common.helper.ValidateCode;

public class ValidateCodeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		HttpSession session = reqeust.getSession();
		
		ValidateCode vCode = new ValidateCode(120,40,4,50);
		session.setAttribute(CommonConstant.VALIDATE_CODE, vCode.getCode());
		vCode.write(response.getOutputStream());
	}
}