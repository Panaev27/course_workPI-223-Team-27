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
	private static String inputNewLogin;
	private static String inputNewPass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestLoginControl LogControl = RequestLoginControl.fromRequestParameters(request);
		if (request.getParameter("create")!=null) {
			if (AuthBaseController.addAuth(inputNewLogin, inputNewPass)) {
				request.setAttribute("labelText", "Учётная запись была удачна добавлена");
			} else {
				request.setAttribute("labelText", "Учётную запись не получилось добавить");
			}
			request.getRequestDispatcher("/Edit.jsp").forward(request, response);
		} else if (request.getParameter("change")!=null) {
			if (AuthBaseController.changeAuth(inputLogin, inputPass, inputNewLogin, inputNewLogin)) {
				request.setAttribute("labelText", "Учётная запись была успешно изменена");
			} else {
				request.setAttribute("labelText", "Учётную запись не получилось изменить");
			}
			request.getRequestDispatcher("/Edit.jsp").forward(request, response);
		} else if (request.getParameter("del")!=null) {
			if (AuthBaseController.deleteAuth(inputLogin, inputPass)) {
				request.setAttribute("labelText", "Учётная запись была успешно удалена");
			} else {
				request.setAttribute("labelText", "Учётную запись не получилось удалить");
			}
			request.getRequestDispatcher("/Edit.jsp").forward(request, response);
		}
	}
	
	private static class RequestLoginControl {
		
		private RequestLoginControl (String login, String pass, String newLogin,String newPass) {
			AuthManager.inputLogin = login;
			AuthManager.inputPass = pass;
			AuthManager.inputNewLogin = login;
			AuthManager.inputNewPass = pass;
			}
		
		public static RequestLoginControl fromRequestParameters(HttpServletRequest request) {
			return new RequestLoginControl(
			request.getParameter("login"),
			request.getParameter("password"),
			request.getParameter("newLogin"),
			request.getParameter("newPassword"));
			}
	}
	
}