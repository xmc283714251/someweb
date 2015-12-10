<p>
<#if label??>
	<label>${label}：</label>
</#if>
	<input id="${id?if_exists}" type="text" name="${name?if_exists}" value="${value?if_exists}" class="date" format="${format?if_exists}" yearstart="${yearstart}" yearend="${yearend}" readonly="true"/>
<#if tipinfo??>
 	<span class="info">${tipinfo}</span>
</#if>
</p>