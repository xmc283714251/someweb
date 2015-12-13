<div id="${id?if_exists}" class="mini-outlooktree"<#rt/>
<#if url??>
  url="${contextPath?if_exists}${url?if_exists}"<#rt/> 
</#if>
<#if onnodeclick??>
  onnodeclick="${onnodeclick?if_exists}"<#rt/>
</#if>
  textField="${textField?if_exists}"<#rt/>
  idField="${idField?if_exists}"<#rt/>
  parentField="${parentField?if_exists}">
</div>