package MyServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Server.Sessions;

@WebServlet("/Exit")
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Сервлет для выхода из аккаунта
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sessions session = new Sessions();
		session.deleteSession(request, response);
	}
}