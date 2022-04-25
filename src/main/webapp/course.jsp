<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Database.Course" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="./Style.css" rel="stylesheet">
	<title>Запись на курс</title>
</head>

<%@ include file="navbar.jsp" %>

<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<div class="container-xxl py-5">
           <div class="container">
               <div class="row g-5 align-items-center">
                   <div class="col-lg-6">
                       <div class="row g-3">
                           <div class="col-6 text-start">
                               <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.1s" src="picture/operator.jpg" style="visibility: visible; animation-delay: 0.1s; animation-name: zoomIn;">
                           </div>
                           <div class="col-6 text-start">
                               <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.3s" src="picture/veb.jpg" style="margin-top: 25%; visibility: visible; animation-delay: 0.3s; animation-name: zoomIn;">
                           </div>
                           <div class="col-6 text-end">
                               <img class="img-fluid rounded w-75 wow zoomIn" data-wow-delay="0.5s" src="picture/veb2.jpg" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;">
                           </div>
                           <div class="col-6 text-end">
                               <img class="img-fluid rounded w-100 wow zoomIn" data-wow-delay="0.7s" src="picture/veb3.jpg" style="visibility: visible; animation-delay: 0.7s; animation-name: zoomIn;">
                           </div>
                       </div>
                   </div>
                   <form class="col-lg-6" method="get" action="/web-app/CourseServlet">
                       <h5 class="section-title ff-secondary text-start text-primary fw-normal">О вебинаре</h5>
                       <h1 class="mb-4">Веб-дизайнер 2.0</h1>
                       <p class="mb-4">Освой основы профессии веб-дизайнера с нуля, за 7 дней под присмотром профессионала, с домашними заданиями и постоянной практикой.</p>
                       <p class="mb-4">Дадим пошаговый алгоритм заработка 60к рублей в этой нише от А до Я (после вебинара вы сможете самостоятельно начать зарабатывать). Бесплатно подарим 3 инструмента, которые нужны для работы в этой нише.</p>
					<div class="row g-4 mb-4">
                           <div class="col-sm-6">
                               <div class="d-flex align-items-center border-start border-5 border-primary px-3">
                                   <h1 class="flex-shrink-0 display-5 text-primary mb-0" data-toggle="counter-up"><%= new Course().getCount() %></h1>
                                   <div class="ps-4">
                                       <p class="mb-0">Человек</p>
                                       <h6 class="text-uppercase mb-0">уже с нами</h6>
                                   </div>
                               </div>
                           </div>
                        <div class="col-sm-6">
                            <div class="d-flex align-items-center border-start border-5 border-primary px-3">
                                <h1 class="flex-shrink-0 display-5 text-primary mb-0" data-toggle="counter-up">0</h1>
                                <div class="ps-4">
                                    <p class="mb-0">Рублей</p>
                                    <h6 class="text-uppercase mb-0">За вход</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-primary py-3 px-5 mt-2" type="submit">Записаться</button>
                </form>
             </div>
        </div>
    </div>
</body>
</html>