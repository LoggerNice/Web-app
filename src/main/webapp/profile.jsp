<%
if(session.getAttribute("currentUser") == null) {
	response.sendRedirect("LoginForm.html");
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Личный кабинет</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="./Style.css" rel="stylesheet">
</head>
<body>

</body>
</html>