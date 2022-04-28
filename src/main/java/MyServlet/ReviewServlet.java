package MyServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Comments;
import Models.User;
import Server.Sessions;

/**
 * Сервлет для добавления новых отзывов
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Comments comment = new Comments();  
	private Sessions session = new Sessions();
	private User user = new User();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("textReview");
		user = session.getSession(request);

		try {
			comment.add(user.getId(), text);
			response.sendRedirect(request.getContextPath() + "/review.jsp");
		} 
		catch (SQLException e) {
			System.out.println("Новый комментарий не был добавлен!");
			e.printStackTrace();
		}
	}

}
