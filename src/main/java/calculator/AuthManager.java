package calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AuthManager", urlPatterns="/JavaAuthManager")
public class AuthManager extends HttpServlet {
	
	private static String inputLogin;
	private static String inputPass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestLoginControl LogControl = RequestLoginControl.fromRequestParameters(request);
		request.setAttribute("login", AuthBaseController.addAuth(inputLogin, inputPass));
		request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
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