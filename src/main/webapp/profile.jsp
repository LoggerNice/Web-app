<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Личный кабинет</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./Style.css" rel="stylesheet">
</head>

<%@ include file="navbar.jsp"%>

<body>
	<section class="h-100 gradient-custom-2">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-lg-9 col-xl-7">
					<div class="card">
						<div class="rounded-top text-white d-flex flex-row bg-dark"
							style="height: 200px;">
							<div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
								<img src="./picture/user.svg" alt="Generic placeholder image"
									class="img-fluid img-thumbnail mt-4 mb-2"
									style="width: 150px; z-index: 1"> <a
									href="editProfile.jsp" class="btn btn-outline-dark"
									data-mdb-ripple-color="dark" style="z-index: 1;">
									Редактировать </a>
							</div>
							<div class="ms-3" style="margin-top: 130px;">
								<h5>
									<%= user.getName() + " " + user.getSurname() %>
								</h5>
								<p>
									<%= user.getCity() %>
								</p>
							</div>
						</div>
						<div class="p-4 text-black" style="background-color: #f8f9fa;">
							<div class="d-flex justify-content-end text-center py-1">
								<div>
									<p class="mb-1 h5">253</p>
									<p class="small text-muted mb-0">Работ</p>
								</div>
								<div class="px-3">
									<p class="mb-1 h5"><%= user.getGender() %></p>
									<p class="small text-muted mb-0">Пол</p>
								</div>
							</div>
						</div>
						<div class="input-group">
							<input type="file" class="form-control" id="inputGroupFile04"
								aria-describedby="inputGroupFileAddon04" aria-label="Upload">
							<button class="btn btn-outline-secondary" type="button"
								id="inputGroupFileAddon04">Button</button>
						</div>
						<div class="d-flex justify-content-between align-items-center m-4">
							<p class="lead fw-normal mb-0">Загруженные работы</p>
							<p class="mb-0">
								<a href="/web-app/WorksServlet" class="text-muted">Посмотреть
									все</a>
							</p>
						</div>
						<div class="row g-2">
							<div class="col mb-2">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(112).webp"
									alt="image 1" class="w-100 rounded-3">
							</div>
							<div class="col mb-2">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(107).webp"
									alt="image 1" class="w-100 rounded-3">
							</div>
						</div>
						<div class="row g-2">
							<div class="col">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(108).webp"
									alt="image 1" class="w-100 rounded-3">
							</div>
							<div class="col">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(114).webp"
									alt="image 1" class="w-100 rounded-3">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>