<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="Style.css" rel="stylesheet">
<title>Связь с нами</title>
</head>

<%@ include file="navbar.jsp"%>

<body>
	<div class="container my-3 py-3">
		<section class="mb-4">

			<h2 class="h1-responsive font-weight-bold text-center my-4">Связь
				с нами</h2>
			<p class="text-center w-responsive mx-auto mb-5">Do you have any
				questions? Please do not hesitate to contact us directly. Our team
				will come back to you within a matter of hours to help you.</p>

			<div class="row">
				<div class="col-md-9 mb-md-0 mb-5">
					<form id="contact-form" name="contact-form"
						action="/web-app/MailServlet" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-floating mb-3">
									<input type="email" class="form-control" id="floatingInput"
										placeholder="name@example.com"> <label
										for="floatingInput">Почта</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="89173085293"> <label for="floatingInput">Номер
										телефона</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-floating mb-3">
									<textarea class="form-control"
										placeholder="Leave a comment here" id="floatingTextarea2"
										style="height: 140px"></textarea>
									<label for="floatingTextarea2">Вопрос</label>
								</div>
							</div>
						</div>
						<div class="text-center text-md-left">
							<button class="btn btn-primary" style="min-width: 150px;"
								type="submit">Отправить</button>
						</div>
					</form>
				</div>
				<div class="col-md-3 text-center">
					<ul class="list-unstyled mb-0">
						<li><img src="./picture/location.svg" style="width: 40px"
							class="fas fa-map-marker-alt fa-2x"></img>
							<p>Трнавская ул., 1, Балаково, Россия</p></li>
						<li><img src="./picture/phone.svg" style="width: 40px"
							class="fas fa-map-marker-alt mt-4 fa-2x"></img>
							<p>+7(927)234-57-89</p></li>
						<li><img src="./picture/mail.svg" style="width: 40px"
							class="fas fa-map-marker-alt mt-4 fa-2x"></img>
							<p>contact@mail.com</p></li>
					</ul>
				</div>
			</div>
		</section>
	</div>
</body>
</html>