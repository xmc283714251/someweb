<p>
<#if label??>
	<label>${label}：</label>
</#if>
<input id="${id?if_exists}" type="${type?if_exists}" name="${name?if_exists}" value="${value?if_exists}"<#rt/>
 <#if minlength??>minlength="${minlength}"</#if><#rt/>
 <#if maxlength??>maxlength="${maxlength}"</#if><#rt/>
 <#if equalto??>equalto="${equalto}"</#if><#rt/>
 <#if min??>min="${min}"</#if><#rt/>
 <#if max??>max="${max}"</#if><#rt/>
 <#if readonly??>readonly="readonly"</#if><#rt/>
 <#if remote??>remote="${remote}"</#if><#rt/>
 <#if disabled??>disabled="disabled"</#if><#rt/>
 <#if alt??>alt="${alt}"</#if><#rt/>
 <#if cssClass??>class="${cssClass}"</#if><#rt/>
/><#rt/>
<#if tipinfo??>
 <span class="info">${tipinfo}</span>
</#if>
</p>