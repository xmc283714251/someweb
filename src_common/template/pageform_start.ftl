<form id="pagerForm" method="post" action="${contextPath}${action}">
	<input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${numPerPage?if_exists}" />
	<input type="hidden" name="orderField" value="${orderField?if_exists}" />
	<input type="hidden" name="orderDirection" value="${orderDirection?if_exists}" />