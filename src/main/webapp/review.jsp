<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Database.Comments"%>
<%@ page import="Models.Comment"%>
<%@ page import="java.util.*"%>
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
							<form method="post" action="/web-app/ReviewServlet"
								style="<% if (currentSession.isSession(request)) out.println(""); else out.println("display:none"); %>">
								<div class="row">
									<div class="col-md-12">
										<div class="form-floating mb-3">
											<textarea class="form-control"
												placeholder="Leave a comment here" id="floatingTextarea2"
												name="textReview"></textarea>
											<label for="floatingTextarea2">Ваш отзыв</label>
										</div>
									</div>
								</div>
								<div class="text-center text-md-left">
									<button class="btn btn-primary" style="min-width: 150px;"
										type="submit">Добавить</button>
								</div>
							</form>
							<div style="<% if (currentSession.isSession(request)) out.println("display:none"); else out.println(""); %>">
								<p style="text-align: center;">
									Пожалуйста, <a href="loginForm.jsp">авторизируйтесь</a>
								</p>
							</div>
						</div>
					</div>

					<%
					Comments comm = new Comments();
					ArrayList<Comment> comment = new ArrayList<Comment>(); 
					comment = comm.select();
					
					for(Comment c: comment) {
						out.print("<div class=\"d-flex flex-start mb-4\">");	
						out.print("<img class=\"rounded-circle shadow-1-strong me-3\" src=\"./avatar/"+ c.getPhoto() +"\" alt=\"avatar\" width=\"65\" height=\"65\" />");
						out.print("<div class=\"card w-100\">");
						out.print("<div class=\"card-body p-4\">");
						out.print("<div>");
						out.print("<h5>" + c.getName() + " " + c.getSurname() +"</h5>");
						out.print("<p class=\"small\">"+ c.getDate() +"</p>");
						out.print("<p>" + c.getText() +"</p>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
						out.print("</div>");
					}
					%>
				</div>
			</div>
		</div>
	</section>
</body>
</html>