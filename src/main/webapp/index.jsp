<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Главная</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="./Style.css" rel="stylesheet">
</head>

<%@ include file="navbar.jsp" %>

<body>
	<div class="container my-3 py-3">	
		<div class="row align-items-center g-5">
			<form class="col-lg-6 text-center text-lg-start">
		            <p class="text-black fw-bold fs-1 lh-sm">Красиво -<br>значит легко</p>
		            <p class="text-black mb-4 pb-2">Обучим дизайну на различные темы, дадим пищу для размышления и направим в правильном направлении. Вместе мы продвинем сферу дизайна, присоединяйся к нам!</p>
		            <a href="course.jsp" class="btn btn-warning py-sm-3 px-sm-5 me-3">Подробнее</a>
			</form>
	        <div class="col-lg-6 text-center text-lg-end overflow-hidden">
	            <img class="img-fluid" src="./picture/img_main.jpg" alt="">
	        </div>
	    </div>
	    
        <div class="row g-4">
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <img style="width: 35%;" class="pb-4" src="./picture/chat-group.png" alt="">
                        <h5 class="pb-1">Большая аудитория</h5>
                        <p>Вместе с нами большое количество людей, желающих стать профессионалами</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <img style="width: 35%;"  class="pb-4" src="./picture/diploma.png" alt="">
                        <h5  class="pb-1">Высокое качество</h5>
                        <p>Если вы выбрали нас, то будьте уверены в наилучшем виде выполнения работ</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <img style="width: 35%;"  class="pb-4" src="./picture/teamwork.png" alt="">
                        <h5  class="pb-1">Лучшие специалисты</h5>
                        <p>В нашей компании только высокообразованные преподаватели</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                <div class="service-item rounded pt-3">
                    <div class="p-4">
                        <img style="width: 35%;"  class="pb-4" src="./picture/thumbs-up.png" alt="">
                        <h5  class="pb-1">Удобство</h5>
                        <p>С нами ваше обучение будет продуктивным, интересным и свободным</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>