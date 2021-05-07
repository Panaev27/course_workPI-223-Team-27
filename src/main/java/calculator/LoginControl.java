package calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LogControl", urlPatterns="/JavaLogControl")
public class LoginControl extends HttpServlet {
	
	public static ArrayList<String> logins;
	public static ArrayList<String> passwords;
	
	public LoginControl() {
		logins.add("1");
		passwords.add("1");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestLoginControl LogControl = RequestLoginControl.fromRequestParameters(request);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}
	
	private static class RequestLoginControl {
		
		private final String inputLogin;
		private final String inputPass;
		
		private RequestLoginControl (String login, String pass) {
			this.inputLogin = login;
			this.inputPass = pass;
			}
		
		public static RequestLoginControl fromRequestParameters(HttpServletRequest request) {
			return new RequestLoginControl(
			request.getParameter("login"),
			request.getParameter("password"));
			}
	}
	
}