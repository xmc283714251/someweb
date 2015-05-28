<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>风险管理平台</title>
<link href="<c:url value='/css/login.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/temple/js/jquery-1.7.1.js'/>"></script>
<script type="text/javascript">
	function clickValidateCode()
	{
		$("#validateCode").attr("src","<c:url value='/getCode.image'/>?t=" + new Date().getTime());
	}
	
	function login()
	{
		var username = $("#username").val();
		var password = $("#password").val();
		var code = $("#code").val();
		if (username == "" || username == null)
		{
			alert("用户名不能为空.");
			return false;
		}
		else if (password == "" || password == null)
		{
			alert("密码不能为空.");
			return false;
		}
		else if (code == null || code == "")
		{
			alert("请输入验证码.");
			return false;
		}
		$("#loginform").submit();
	}
	
	$(function(){
		$(document).keydown(function(event){
			//绑定回车
			if(event.keyCode == 13)
			{  
				 login();
			} 
		});
	
		$("#loginbtn").click(function(){
			login();
		})
	});
</script>
</head>
<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="http://demo.dwzjs.com"><img src="images/login/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="http://bbs.dwzjs.com">反馈</a></li>
						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="images/login/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form id="loginform" name="loginform" action="<c:url value='/login.do'/>" method="post" >
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td colspan="2" align="center">
								<font color="red">${errorMsg}</font>
							</td>
						</tr>
						<tr>
							<td colspan="2" height="5px">&nbsp;</td>
						</tr>
						<tr>
							<td width="25%">用户名：</td>
							<td><input type="text" id="username" name="username" size="20" class="login_input" maxlength="20"/></td>
						</tr>
						<tr>
							<td colspan="2" height="10px">&nbsp;</td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
							<td><input type="password" id="password" name="password" size="20" class="login_input" /></td>
						</tr>
						<tr>
							<td colspan="2" height="10px">&nbsp;</td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td>
								<input class="code" id="code" name="code" type="text" size="8" />
								<span onclick="clickValidateCode()" style="cursor: pointer;" title="点击更换验证码">
									<img id="validateCode" src="<c:url value='/getCode.image'/>" alt="点击更换验证码" width="75" height="25" />
								</span>
							</td>
						</tr>
						<tr>
							<td colspan="2" height="10px">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="login_bar">
									<input id="loginbtn" class="sub" type="button" title="登陆" value=" "/>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="login_banner"><img src="images/login/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					 
				</ul>
				<div class="login_inner">
					 
				</div>
			</div>
		</div>
		<div id="login_footer">
			熊明春开发平台
		</div>
	</div>
</body>
</html>