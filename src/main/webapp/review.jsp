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
<title>Отзывы</title>
</head>

<%@ include file="navbar.jsp"%>

<body style="background-color: #e7effd;">
	<section>
		<div class="container my-5 text-dark">
			<div class="row d-flex justify-content-center">
				<div class="col-md-11 col-lg-9 col-xl-7">
					<div class="card w-100 mb-5">
						<div class="card-body p-4">
							<h5 class="mb-4" style="text-align: center;">Новый комментарий</h5>
							<form method="post" action="/web-app/ReviewServlet">
								<div class="row">
									<div class="col-md-12">
										<div class="form-floating mb-3">
											<textarea class="form-control"
												placeholder="Leave a comment here" id="floatingTextarea2"></textarea>
											<label for="floatingTextarea2">Ваш отзыв</label>
										</div>
									</div>
								</div>
								<div class="text-center text-md-left">
									<button class="btn btn-primary" style="min-width: 150px;" type="submit">Добавить</button>
								</div>
							</form>
						</div>
					</div>

					<div class="d-flex flex-start mb-4">
						<img class="rounded-circle shadow-1-strong me-3"
							src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(32).webp"
							alt="avatar" width="65" height="65" />
						<div class="card w-100">
							<div class="card-body p-4">
								<div class="">
									<h5>Johny Cash</h5>
									<p class="small">3 hours ago</p>
									<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel
										metus scelerisque ante sollicitudin. Cras purus odio,
										vestibulum in vulputate at, tempus viverra turpis. Fusce
										condimentum nunc ac nisi vulputate fringilla. Donec lacinia
										congue felis in faucibus ras purus odio, vestibulum in
										vulputate at, tempus viverra turpis.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>