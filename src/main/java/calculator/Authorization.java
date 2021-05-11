package calculator;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Auth", urlPatterns="/JavaAuth")
public class Authorization extends HttpServlet {
	
	private static String inputLogin;
	private static String inputPass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestAuth Auth = RequestAuth.fromRequestParameters(request);
		if (AuthBaseController.checkAuth(inputLogin, inputPass)) {
			request.getRequestDispatcher("/Form.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
		};
	}
	
	private static class RequestAuth {
		
		private RequestAuth (String login, String pass) {
			Authorization.inputLogin = login;
			Authorization.inputPass = pass;
			
			}
		
		public static RequestAuth fromRequestParameters(HttpServletRequest request) {
			return new RequestAuth(
			request.getParameter("login"),
			request.getParameter("password"));
			}
	}
	
}