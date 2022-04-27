<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Server.Sessions" %>
<%@ page import="Models.User" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="./Style.css" rel="stylesheet">
</head>
<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex justify-content-between">
      	<div class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none justify-content-lg-start">      	
	        <a href="/" class="me-2">
	          <img width="40" height="40" src="./picture/logo.png" alt="logo"></img>
	        </a>
	        <a href="index.jsp" class="nav-link px-2 text-secondary me-3">Design Studio</a>
      	</div>
        <ul class="nav mb-2 mb-md-0">
          <li><a href="index.jsp" class="nav-link px-2 text-secondary">Главная</a></li>
          <li><a href="course.jsp" class="nav-link px-2 text-white">Вебинары</a></li>
          <li><a href="review.jsp" class="nav-link px-2 text-white">Отзывы</a></li>
          <li><a href="contact.jsp" class="nav-link px-2 text-white">Контакты</a></li>
        </ul>
        <form class="text-end d-flex flex-wrap justify-content-lg-end" method="get" action="/web-app/Exit">
          <%
          Sessions currentSession = new Sessions();
		  User user = new User();
		  user = currentSession.getSession(request);
          
          if (currentSession.isSession(request))
          	out.println("<a href=\"profile.jsp\" class=\"nav-link px-2 text-secondary me-2\"> " + user.getName() + " " + user.getSurname() + "</a> <button type=\"submit\" class=\"btn btn-warning\">Выйти</button>");
          else
            out.println("<a href=\"loginForm.jsp\" class=\"btn btn-warning\">Войти</a>");
          %>
        </form>
      </div>
    </div>
</header>
</html>