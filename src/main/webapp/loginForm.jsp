<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <div class="position-absolute top-50 start-50 translate-middle">
        <h1>Авторизация</h1>
        <form class="mt-5" method="post" action="/web-app/LoginServlet">
            <div class="mb-3">
                <label for="log" class="form-label">Логин</label>
                <input placeholder="Ваш логин" name="Login" type="text" class="form-control" id="log">
            </div>
            <div class="mb-3">
                <label for="pass" class="form-label">Пароль</label>
                <input placeholder="Ваш пароль" name="Password" type="password" class="form-control" id="pass">
            </div>
            <button type="submit" class="btn btn-primary">Войти</button>
        </form>
        <p class="mt-2">
        	Нет аккаунта?
        	<a href="registration.jsp">Зарегистрируйся</a>
        </p>
    </div>
</body>
</html>