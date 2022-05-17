package Server;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.User;

public class Sessions {
	private User user = new User();
	
	public void setSession(HttpServletRequest request, int id, String login, String password, String name, String surname, String gender, String city, String photo) {
		user = new User(id, login, password, name, surname, gender, city, photo);
		HttpSession session = request.getSession();
		session.setAttribute("currentUser", user);
		session.setMaxInactiveInterval(60*60*24);
	}
	
	public User getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (User) session.getAttribute("currentUser");
	}
	
	public boolean isSession(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("currentUser") == null)
			return false;
		return true;
	}
	
	public void deleteSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}