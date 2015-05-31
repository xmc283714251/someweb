<div class="panelBar" >
	<div class="pages">
		<span>每页</span>
		<#if targetType=='navTab'>
			<select name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
		<#else>
			<select name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})">
		</#if>
		<#list pageModels as num>
			<#if numPerPage==num>
				<option value="${num}" selected="selected">${num}</option>
			<#else>
				<option value="${num}">${num}</option>
			</#if>
		</#list>
		</select>
		<span>条，共<font color="red">${totalPage?if_exists}</font>页，总数<font color="red">${totalCount?if_exists}</font>条</span>
	</div>
	<div class="pagination" rel="${rel?if_exists}" targetType="${targetType?if_exists}" totalCount="${totalCount?if_exists}" numPerPage="${numPerPage?if_exists}" pageNumShown="${pageNumShown?if_exists}" currentPage="${currentPage?if_exists}"></div>
</div>