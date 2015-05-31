<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="accordion" fillSpace="sideBar">
	<div class="accordionHeader">
		<h2><span>Folder</span>系统管理</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree treeFolder">
			<li><a href="<c:url value='/xtgl/toUserManagerPage.do'/>" target="navTab" rel="xtgl_UserManagerPage">用户管理</a></li>
			<li><a href="demo_page1.html" target="navTab" rel="demo_page1">机构管理</a></li>
			<li><a href="demo_page1.html" target="navTab" rel="demo_page2">角色管理</a></li>
			<li><a href="demo_page4.html" target="navTab" rel="demo_page4">功能管理</a></li>
		</ul>
	</div>
</div>
