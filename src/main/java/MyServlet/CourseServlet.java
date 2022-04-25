package MyServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Course;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//СДЕЛАТЬ УНИКАЛЬНОСТЬ ЗАПИСЕЙ РЕГИСТРАЦИИ 
	
	//Сервлет для записи на курс
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = null;
		Course course = new Course();
		String cookieName = "id";
		HttpSession session = request.getSession();
		Cookie [] cookies = (Cookie []) request.getCookies();
		
		if (session.getAttribute("currentUser") == null || request.getCookies() == null)
			response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
        else
    	  for (Cookie cookie : cookies)
    		if (cookieName.equals(cookie.getName())) {
    			id = cookie.getValue();
    			break;
    		}
    		else continue;

		try {
			course.addUser(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Пользователь с id: " + id + " был добавлен!");
		response.sendRedirect(request.getContextPath() + "/course.jsp");
	}
}