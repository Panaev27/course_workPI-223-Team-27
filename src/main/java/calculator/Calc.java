package calculator;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc")
public class Calc extends HttpServlet {
	
	public static String radiusGet;
	public static String heightGet;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		PDFWriter PDF = new PDFWriter();
		PDF.Create();
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}
	
	private static class RequestCalc {
		private final String radius_calc;
		private final String height_calc;
		private double result;
						
		private RequestCalc (String radius, String height) {
			this.radius_calc = radius;
			this.height_calc = height;
			radiusGet=radius;
			heightGet=height;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("radius"),
			request.getParameter("height"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("radius_result", radius_calc);
			request.setAttribute("height_result", height_calc);
			double radius_try;
			double height_try;
			try { 
			radius_try=Double.parseDouble(radius_calc);
			height_try=Double.parseDouble(height_calc);
			}
			catch (NumberFormatException e) {
			radius_try=0;
			height_try=0;	
			}
			result=2*Math.PI*radius_try*height_try+2*Math.PI*Math.pow(radius_try,2);
			request.setAttribute("result",  new File("/app").exists());
		}
		
	}
	
	
}
