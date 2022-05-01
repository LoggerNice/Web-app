<%@page import="java.util.Random"%>
<%@page import="Models.Kapcha"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/jbootstrap.bundle.min.js"></script>
    <div class="container mt-5 px-5 w-50">
        <h1 style="text-align:center">Регистрация</h1>
        <form class="mt-5 was-validated" method="post" action="/web-app/RegistrationServlet">
          <div class="form-row">
		    <div class="mb-3">
		      <label for="validationServer01">Ваше имя</label>
		      <input name="Name" type="text" class="form-control" id="validationServer01" placeholder="Имя" value="" required>
		      <div class="invalid-feedback">Пожалуйста, укажите имя</div>
		    </div>
		    <div class="mb-3">
		      <label for="validationServer02">Ваша фамилия</label>
		      <input name="Surname" type="text" class="form-control" id="validationServer02" placeholder="Фамилия" value="" required>
		      <div class="invalid-feedback">Пожалуйста, укажите фамилию</div>
		    </div>
		    <div class="mb-3">
		      <label for="validationServer02">Ваш город</label>
		      <input name="City" type="text" class="form-control" id="validationServer03" placeholder="Город" value="" required>
		      <div class="invalid-feedback">Пожалуйста, укажите ваш город</div>
		    </div>
		    <div class="mb-3">
		      <label for="validationServerUsername">Ваш логин</label>
		      <div class="input-group">
		        <div class="input-group-prepend">
		          <span class="input-group-text" id="inputGroupPrepend3">@</span>
		        </div>
		        <input name="Login" type="text" class="form-control" id="validationServerUsername" placeholder="Логин" aria-describedby="inputGroupPrepend3" required>
		        <div class="invalid-feedback">Пожалуйста, введите логин</div>
		      </div>
		    </div>
		  </div>
		  <div class="form-row">
		    <div class="mb-3">
		      <label for="validationServer03">Ваш пароль</label>
		      <input name="Password" type="password" class="form-control" id="validationServer03" placeholder="Пароль" required>
		      <div class="invalid-feedback">Пожалуйста, введите пароль</div>
		    </div>
		  </div>
		  <div class="form-group mb-3">
		    <div class="custom-control custom-checkbox mb-3">
			  <input type="checkbox" class="custom-control-input" id="customControlValidation1" required>
			  <label class="custom-control-label" for="customControlValidation1">Я согласен с правилами</label>
			  <div class="invalid-feedback">Пожалуйста, подтвердите соглашение</div>
			</div>
		  </div>
		  <div class="form-row mb-3">
		    <div class="custom-control custom-radio">
		      <input name="Gender" value="Man" type="radio" class="custom-control-input" id="customControlValidation2" name="radio-stacked" required>
		      <label class="custom-control-label" for="customControlValidation2">Мужской</label>
		    </div>
		    <div class="custom-control custom-radio mb-3">
		      <input name="Gender" value="Woman" type="radio" class="custom-control-input" id="customControlValidation3" name="radio-stacked" required>
		      <label class="custom-control-label" for="customControlValidation3">Женский</label>
		      <div class="invalid-feedback">Пожалуйста, выберите пол</div>
		    </div>
		    <div class="form-row">
		    <div class="mb-3">
		      <label for="validationServer03">Решите пример:
		      <%
		      Kapcha kap = new Kapcha();
		      %>
		      <%= kap.getMath() %>
		      </label>
		      <input name="Result" type="text" class="form-control" id="validationServer03" placeholder="Ответ" required>
		      <div class="invalid-feedback">Пожалуйста, введите ответ</div>
		    </div>
		      <input name="Kapcha" type="hidden" value="<%= kap.getResult()%>">
		  </div>
		  </div>
		  <button class="btn btn-primary" type="submit">Зарегистрироваться</button>
        </form>
        <p class="mt-2"> Уже есть аккаунт? <a href="loginForm.jsp">Авторизоваться</a> </p>
    </div>
</body>
</html>