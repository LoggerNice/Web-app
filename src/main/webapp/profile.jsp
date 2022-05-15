<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Database.Image"%>
<%@ page import="java.util.*"%>
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

<body style="background-color: #e7effd;">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<section class="h-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-lg-9 col-xl-7">
					<div class="card">
						<div class="rounded-top text-white d-flex flex-row bg-dark"
							style="height: 200px;">
							<div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
								<img src="./avatar/<%=user.getPhoto()%>"
									alt="Generic placeholder image"
									class="img-fluid img-thumbnail mt-4 mb-2"
									style="width: 150px; z-index: 1"> <a
									href="editProfile.jsp" class="btn btn-outline-dark"
									data-mdb-ripple-color="dark" style="z-index: 1;">
									Редактировать </a>
							</div>
							<div class="ms-3" style="margin-top: 130px;">
								<h5>
									<%=user.getName() + " " + user.getSurname()%>
								</h5>
								<p>
									<%=user.getCity()%>
								</p>
							</div>
						</div>
						<div class="p-4 text-black" style="background-color: #f8f9fa;">
							<div class="d-flex justify-content-end text-center py-1">
								<div>
									<%
									Image img = new Image();
									ArrayList<String> images = new ArrayList<String>();
									images = img.getWorks(user.getId());
									%>
									<p class="mb-1 h5"><%=images.size()%></p>
									<p class="small text-muted mb-0">Проекты</p>
								</div>
								<div class="px-3">
									<p class="mb-1 h5"><%=user.getGender()%></p>
									<p class="small text-muted mb-0">Пол</p>
								</div>
							</div>
						</div>
						<form class="input-group px-4" method="post"
							action="UploadServlet" enctype="multipart/form-data">
							<input type="file" class="form-control" name="img"
								id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
								aria-label="Upload">
							<button class="btn btn-outline-secondary" type="submit"
								id="inputGroupFileAddon04">Загрузить</button>
						</form>
						<div class="d-flex justify-content-between align-items-center m-4">
							<p class="lead fw-normal mb-0">Загруженные работы</p>
						</div>

						<div id="carouselExampleFade" class="carousel slide carousel-fade"
							data-bs-ride="carousel">
							<div class="carousel-inner px-4 mb-4">
								<%
								String path = "./works/";

								for (int i = 0; i < images.size(); i++) {
									if (i == 0)
										out.print("<div class=\"carousel-item active\">");
									else
										out.print("<div class=\"carousel-item\">");

									out.print("<img src=\"" + path + images.get(i) + "\" alt=\"image 1\" class=\"d-block w-100\">");
									out.print("</div>");
								}
								%>
								<button class="carousel-control-prev" type="button"
									data-bs-target="#carouselExampleFade" data-bs-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Previous</span>
								</button>
								<button class="carousel-control-next" type="button"
									data-bs-target="#carouselExampleFade" data-bs-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="visually-hidden">Next</span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>