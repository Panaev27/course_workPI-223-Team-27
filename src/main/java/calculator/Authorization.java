package calculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Сервлет для авторизации
@WebServlet(name="Auth", urlPatterns="/JavaAuth")
public class Authorization extends HttpServlet {
	//Полученые с страницы данные
	private static String inputLogin;
	private static String inputPass;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inputLogin = request.getParameter("login");
		inputPass = request.getParameter("password");
		
		request.getSession().setAttribute("AuthCorrect", "false");
		request.getSession().setAttribute("AuthAdminCorrect", "false");
		
		//Проверяем введёные данные
		if (AuthBaseController.checkAuth(inputLogin, inputPass)) {
			request.getSession().setAttribute("AuthCorrect", "true");
			
			//Проверяем введёные данные, если они админские
			if (inputLogin.equals("admin") && inputPass.equals("password")) {
				request.getSession().setAttribute("AuthAdminCorrect", "true");
				request.getRequestDispatcher("/Edit.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/Form.jsp").forward(request, response);
			}
			
		} else {
			request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
		};
	}
	
}