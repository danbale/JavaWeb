<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	final String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>JSTL Application</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">JSTL Application</h2>
	<hr>
	<h3>Examples:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="/Cart/List"/>">Carts</a></li>
		<li><a href="<c:url value="/User/List"/>">Users</a></li>
	</ul>
</body>
</html>