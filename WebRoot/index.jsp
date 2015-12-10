<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sm" uri="/someweb-tags"%>
<sm:view title="系统登陆">
<link href="<c:url value='/css/login.css'/>" rel="stylesheet" type="text/css" />
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
		mini.alert("用户名不能为空.");
		return false;
	}
	else if (password == "" || password == null)
	{
		mini.alert("密码不能为空.");
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
<div id="login">
	<div id="login_header">
		<h1 class="login_logo">
			<a href="#"><img src="images/login/login_logo.gif" /></a>
		</h1>
		<div class="login_headerContent">
			<div class="navList">
				<ul>
					<li><a href="#">设为首页</a></li>
					<li><a href="#">反馈</a></li>
					<li><a href="#" target="_blank">帮助</a></li>
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
						<td><input type="text" id="username" value="${username }" name="username" size="20" class="login_input" maxlength="20"/></td>
					</tr>
					<tr>
						<td colspan="2" height="10px">&nbsp;</td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
						<td><input type="password" id="password" value="${password }" name="password" size="20" class="login_input" /></td>
					</tr>
					<tr>
						<td colspan="2" height="10px">&nbsp;</td>
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
</sm:view>