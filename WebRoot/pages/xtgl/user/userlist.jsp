<%@page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="some" uri="/someweb-tags"%>
<div class="pageHeader">
	<form id="searchform" rel="pagerForm" onsubmit="return navTabSearch(this);" action="<c:url value='/xtgl/toUserManagerPage.action'/>" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>
						用户名： 
					</td>
					<td>
						<input type="text" name="userBean.username" value="${userBean.username }"/>
					</td>
					<td>
						真实姓名： 
					</td>
					<td>
						 <input type="text" name="userBean.realname" value="${userBean.realname }"/>
					</td>
					<td>
						创建日期： 
					</td>
					<td>
						 <input type="text" name="userBean.createdate" class="date" value="${userBean.createdate }"/>
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
					<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<some:ToolBar>
		<some:ToolBarButton type="add" text="新增" action="/xtgl/toUserManagerPage.action" target="dialog"/>
		<some:ToolBarButton type="edit" text="修改" action="/xtgl/toUserManagerPage.action" target="navTab"/>
		<some:ToolBarButton type="delete" text="删除" action="" target="ajaxTodo" operaTip="你确定要删除选择记录吗?"/>
		<some:ToolBarButton type="icon" text="导出" targetType="navTab" target="dwzExport"/>
	</some:ToolBar>
	<some:TableGrid id="mytable" layoutH="135" action="/xtgl/toUserManagerPage.action">
		<thead>
			<tr>
				<th width="30px" align="center">序号</th>
				<th width="10px">
					<input type="checkbox" group="userids" class="checkboxCtrl">
				</th>
				<th>用户ID</th>
				<th>用户名</th>
				<th>用户姓名</th>
				<th>用户电话</th>
				<th>用户Email</th>
				<th>创建时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${loginInfoList}" var="loginInfo" varStatus="st">
				<tr target="sid_user" rel="${loginInfo.userid}" >
					<td align="center">${st.index + 1 }</td>
					<td>
						<input name="userids" type="checkbox" value="${loginInfo.userid}">
					</td>
					<td>${loginInfo.userid }</td>
					<td>${loginInfo.username}</td>
					<td>${loginInfo.realname}</td>
					<td>${loginInfo.phone}</td>
					<td>${loginInfo.email }</td>
					<td>${loginInfo.createdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</some:TableGrid>
</div>

