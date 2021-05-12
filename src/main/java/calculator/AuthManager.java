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
		
		if (AuthBaseController.addAuth(inputLogin, inputPass)) {
			request.setAttribute("labelText", "Учётная запись была удачна добавлена");
		} else {
			request.setAttribute("labelText", "Учётную запись не получилось добавить");
		}
		request.getRequestDispatcher("/Edit.jsp").forward(request, response);
	}
	
	private static class RequestLoginControl {
		
		private RequestLoginControl (String login, String pass) {
			AuthManager.inputLogin = login;
			AuthManager.inputPass = pass;
			}
		
		public static RequestLoginControl fromRequestParameters(HttpServletRequest request) {
			return new RequestLoginControl(
			request.getParameter("login"),
			request.getParameter("password"));
			}
	}
	
}