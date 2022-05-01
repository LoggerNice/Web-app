package MyServlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.*;
import Models.User;
import Server.Sessions;

/**
 * Сервлет для редактирования данных пользователя
 */
@MultipartConfig
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Image img = new Image();
    private User userMD = new User();
    private Users userDB = new Users();
    private Sessions session = new Sessions();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userMD = session.getSession(request);
		
		String name = request.getParameter("Name");
		String surname = request.getParameter("Surname");
		String city = request.getParameter("City");
		
		Part part = request.getPart("img");
		String filename = part.getSubmittedFileName();
		String folder = "avatar";
		
		try {
			img.upload(filename, folder, part, request);
			userDB.updateUser(name, surname, city, filename, userMD.getId());
			
			session.deleteSession(request, response);
			session.setSession(request, userMD.getId(), userMD.getLogin(), userMD.getPassword(), name, surname, userMD.getGender(), city, filename);
			
			response.sendRedirect(request.getContextPath() + "/profile.jsp");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
