<%@page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="some" uri="/someweb-tags"%>
<div class="pageHeader">
	<form id="searchform" rel="pagerForm" onsubmit="return navTabSearch(this);" action="<c:url value='/xtgl/toUserManagerPage.action'/>" method="post">
		<div class="pageFormContent">
			<some:TextField id="username" label="用户名" name="username" required="true" isAlphanumeric="true"/>
			<some:TextField id="realname" label="真实姓名" name="realname"/>
			<some:Date id="createdate" label="创建时间" name="createdate"/>
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

