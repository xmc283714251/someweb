<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>
<script type="text/javascript" src="<c:url value='/theme/boot.js'/>"></script>
<script type="text/javascript">
	var contextPath = "${contextPath}";
</script>