package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.Quest;

/**
 * Сервлет для обработки заявки вопроса
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Quest quest = new Quest();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("Mail");
		String phone = request.getParameter("Phone");
		String text = request.getParameter("Text");
		
		try {
			quest.add(text, phone, mail);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/thanks.jsp");
	}

}