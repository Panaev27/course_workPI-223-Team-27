package rgr;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calculator", urlPatterns="/JavaCalculator")
public class Calculator extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.CalculateHangarCost(request);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final HashMap<String, Double> promoMap; //�������� ���������
		private final int[] ArrDoor; //�����
		private final double[] ArrTime; //���� ����������
		private final double[] ArrType; //��� �������������
		private final int[] ArrFoundation; //���������
		private final int[] ArrPanel; //������
		private final String inputDoor;
		private final String inputTime;
		private final String inputx;
		private final String inputy;
		private final String inputz;
		private final String inputType;
		private final String inputFoundation;
		private final String inputFormHangar;
		private final String inputPromo;
		private final String inputPanel;
		
		private RequestCalc (String door, String time,String x,String y,String z,String type,String foundation,String formHangar,String promo,String panel) {
			this.inputDoor = door;
			this.inputTime = time;
			this.inputx = x;
			this.inputy = y;
			this.inputz = z;
			this.inputType = type;
			this.inputFoundation = foundation;
			this.inputFormHangar = formHangar;
			this.inputPromo = promo;
			this.inputPanel = panel;
			promoMap = new HashMap<String, Double>(); //�������� ���������
			ArrDoor = new int[]{6900, 9000, 8400, 4000}; //�����
			ArrTime = new double[]{0.5, 0.75, 1, 2.5}; //���� ����������
			ArrType = new double[]{1.15,1}; //��� �������������
			ArrFoundation = new int[]{0,650,3000,1400}; //���������
			ArrPanel = new int[]{1200,1600,2500}; //������
			promoMap.put("Romashka", 0.9);
			promoMap.put("sudo getZachet", 0.5);
			promoMap.put("Kaz", 0.85);
			promoMap.put("Demin", 3.0);
			promoMap.put("1", 0.999);
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("door"),
			request.getParameter("time"),
			request.getParameter("x"),
			request.getParameter("y"),
			request.getParameter("z"),
			request.getParameter("type"),
			request.getParameter("foundation"),
			request.getParameter("formHangar"),
			request.getParameter("promo"),
			request.getParameter("panel"));
			}
		public double CalculateHangarCost(HttpServletRequest request) {
			request.setAttribute("doorResult", inputDoor);
			request.setAttribute("timeResult", inputTime);
			request.setAttribute("xResult", inputx);
			request.setAttribute("yResult", inputy);
			request.setAttribute("zResult", inputz);
			request.setAttribute("typeResult", inputType);
			request.setAttribute("foundationResult", inputFoundation);
			request.setAttribute("formHangarResult",inputFormHangar);
			request.setAttribute("promoResult",inputPromo);
			request.setAttribute("panelResult",inputPanel);
			int door;
			int time;
			double x;
			double y;
			double z;
			int type;
			int foundation;
			int formHangar;
			String promo = inputPromo;
			int panel;
			try { 
				door=Integer.parseInt(inputDoor);
				time=Integer.parseInt(inputTime);
				x=Double.parseDouble(inputx);
				y=Double.parseDouble(inputy);
				z=Double.parseDouble(inputz);
				type=Integer.parseInt(inputType);
				foundation=Integer.parseInt(inputFoundation);
				formHangar=Integer.parseInt(inputFormHangar);
				panel=Integer.parseInt(inputPanel);
				}
				catch (NumberFormatException e) {
					door=0;
					time=0;
					x=0;
					y=0;
					z=0;
					type=0;
					foundation=0;
					formHangar=0;
					panel=0;
				}
			double price = 0;
			Hangar hangar;
			switch(formHangar) {
			case(0):
				hangar = new ArcHangar(z,y,x);
				break;
			case(1):
				hangar = new BoxHangar(z,y,x);
				break;
			case(2):
				hangar = new TentHangar(z,y,x);
				break;
			default:
				hangar = new ArcHangar(z,y,x);
				break;
			 }
			price = (hangar.getHangarArea()*ArrPanel[panel]*ArrType[type]+hangar.getHangarFoundationArea()*ArrFoundation[foundation]+hangar.getHangarDoorArea()*ArrDoor[door])*getTime(time)*getPromo(promo);
			return Math.floor(price*100)/100;
		}
		//�������� ������������ � ����������� �� �������
		private double getTime(int time) {
			if (time<2) {
				return ArrTime[3];
			} else if (time>=2&&time<=6) {
				return ArrTime[2];
			} else if (time>6&&time<=12) {
				return ArrTime[1];
			} else {
				return ArrTime[0];
			}
		}
		
		public double getPromo(String promo) {
	        if (promoMap.containsKey(promo)) {
	            return promoMap.get(promo);
	        } else {
	            return 1;
	        }
	    }
	}
	
}