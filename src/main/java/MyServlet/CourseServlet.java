package MyServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.Course;
import Models.User;
import Server.Sessions;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Sessions session = new Sessions();
	private User user = new User();
	private Course course = new Course();
	
	//СДЕЛАТЬ УНИКАЛЬНОСТЬ ЗАПИСЕЙ РЕГИСТРАЦИИ 
	
	//Сервлет для записи на курс
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (session.isSession(request)) {
			try {
				user = session.getSession(request);
				course.add(user.getId());
				
				System.out.println("Пользователь с id: " + user.getId() + " был добавлен!");
				response.sendRedirect(request.getContextPath() + "/course.jsp");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
        else
        	response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
	}
}