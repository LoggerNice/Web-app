package MyServlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import Database.Image;
import Models.User;
import Server.Sessions;

/**
 * Сервлет загрузки новой работы пользователя
 */
@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Image img = new Image();
	private Sessions session = new Sessions();
	private User user = new User();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user = session.getSession(request);
		Part part = request.getPart("img");
		String filename = part.getSubmittedFileName();
		String folder = "works";
		
		try {
			img.addWorks(filename, user.getId());
			img.upload(filename, folder, part, request);
			
			System.out.println("Файл добавлен!");
			
			response.sendRedirect(request.getContextPath() + "/profile.jsp");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}