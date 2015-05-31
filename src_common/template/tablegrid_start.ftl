<div id="${id?if_exists}">
<form id="pagerForm" method="post" action="${contextPath}${action?if_exists}">
	<input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${numPerPage?if_exists}" />
	<input type="hidden" name="orderField" value="${orderField?if_exists}" />
	<input type="hidden" name="orderDirection" value="${orderDirection?if_exists}" />
</form>
<table class="${type?if_exists}" layoutH="${layoutH?if_exists}" width="${width?if_exists}" targetType="${targetType?if_exists}" asc="asc" desc="desc">