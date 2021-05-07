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
		LoginControl log = new LoginControl();
		if (trueAuth(inputLogin, inputPass)) {
			request.getRequestDispatcher("/Form.jsp").forward(request, response);
		};
	}
	
	private boolean trueAuth (String login, String pass) {
		for (int i=0;i<LoginControl.logins.size();i++) {
			if (LoginControl.logins.get(i)==inputLogin && LoginControl.passwords.get(i)==inputPass) {
				return true;
			}
		}
		return false;
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