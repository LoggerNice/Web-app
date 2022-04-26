package Server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	private Cookie cookieID = null;
	private Cookie cookieName = null;
	private Cookie cookieSurname = null;
	private Cookie cookieGender = null;
	private Sessions session = new Sessions();
	
	public void setCookie(HttpServletResponse response, String id, String name, String surname, String gender) {
		cookieID = new Cookie("id", id);
		cookieName = new Cookie("name", name); 
		cookieSurname = new Cookie("surname", surname);
		cookieGender = new Cookie("gender", gender);
		
		cookieID.setMaxAge(30 * 24 * 60 * 60);
		cookieName.setMaxAge(30 * 24 * 60 * 60);
		cookieSurname.setMaxAge(30 * 24 * 60 * 60);
		cookieGender.setMaxAge(30 * 24 * 60 * 60);
		
		response.addCookie(cookieID);
		response.addCookie(cookieName);
		response.addCookie(cookieSurname);
		response.addCookie(cookieGender);
	}
	
	public Object getCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<String> data = new ArrayList<String>();
        if (session.isSession(request)) {
        	data.add(cookieID.getValue());
        	data.add(cookieName.getValue());
        	data.add(cookieSurname.getValue());
        	data.add(cookieGender.getValue());
        	
        	return data;
        }
        else
        	return null;
	}
}