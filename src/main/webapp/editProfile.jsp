<%@page import="Server.Sessions"%>
<%@page import="Models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Редактирование профиля</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/jbootstrap.bundle.min.js"></script>
	<%
	User user = new User();
	Sessions s = new Sessions();
	user = s.getSession(request);
	%>
	<div class="container mt-5 px-5 w-50">
		<h1 style="text-align: center">Редактирование данных</h1>
		<form class="mt-5 was-validated" method="post"
			action="/web-app/EditServlet" enctype="multipart/form-data"
			style="<% if (s.isSession(request)) out.println(""); else out.println("display:none"); %>">
			<div class="form-row">
				<div class="mb-3">
					<label for="validationServer01">Ваше имя</label> <input name="Name"
						type="text" class="form-control" id="validationServer01"
						placeholder="Имя" value="<%=user.getName()%>" required>
					<div class="invalid-feedback">Пожалуйста, укажите имя</div>
				</div>
				<div class="mb-3">
					<label for="validationServer02">Ваша фамилия</label> <input
						name="Surname" type="text" class="form-control"
						id="validationServer02" placeholder="Фамилия"
						value="<%=user.getSurname()%>" required>
					<div class="invalid-feedback">Пожалуйста, укажите фамилию</div>
				</div>
				<div class="mb-3">
					<label for="validationServer03">Ваш город</label> <input
						name="City" type="text" class="form-control"
						id="validationServer03" placeholder="Город"
						value="<%= user.getCity() %>" required>
					<div class="invalid-feedback">Пожалуйста, укажите ваш город</div>
				</div>
				<div class="mb-3">
					<input type="file" class="form-control" name="img"
						id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
						aria-label="Upload">
				</div>
			</div>
			<button class="btn btn-primary" type="submit"
				style="min-width: 150px;">Изменить</button>
		</form>
		<div
			style="<% if (s.isSession(request)) out.println("display:none"); else out.println(""); %>">
			<p style="text-align: center;">
				Пожалуйста, <a href="loginForm.jsp">авторизируйтесь</a>
			</p>
		</div>
	</div>
</body>
</html>