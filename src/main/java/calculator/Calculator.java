package calculator;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filework.PDFWriter;

@WebServlet(name="Calc", urlPatterns="/JavaCalc")
public class Calculator extends HttpServlet {
	
	public static String[] outputForFile;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.CalculateHangarCost(request);
		//Создаём Pdf файл
		PDFWriter PDF = new PDFWriter();
		PDF.write(outputForFile);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}
	
	private static class RequestCalc {
		private final HashMap<String, Double> promoMap; //Хеш-меп с промокодами и соответствующими коофициентами скидки
		private final int[] ArrDoor; //Цены дверей
		private final double[] ArrTime; //Цены, в зависимости от времени
		private final double[] ArrType; //Цены от типа ангара
		private final int[] ArrFoundation; //Цены от типа фундамента
		private final int[] ArrPanel; //Цены от вида панелей
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
		//Массивы для перевода выбранного пункта листа в текст
		String[] typeToString = {"Каркасно-рамочные", "Каркасно-щитовой"};
		String[] formToString = {"Арочный", "Прямостенный", "Шатровый"};
		String[] panelToString = {"Облегчённая сендвич-панель", "Сендвич-панель", "Утеплённая сендвич-панель"};
		String[] foundationToString = {"Отсутствие", "Каменный", "Железобетонный", "Бетонный"};
		String[] doorToString = {"Распашные", "Подъёмно-секционные", "Шторные", "Рулонные"};
		String[] typeToStringEn = {"Frame-carcass", "Frame-board"};
		String[] formToStringEn = {"Arc", "Box", "Tent"};
		String[] panelToStringEn = {"Light panel", "Panel", "Heavy panel"};
		String[] foundationToStringEn = {"None", "Stone", "Reinforced concrete", "Concrete"};
		String[] doorToStringEn = {"Swing", "Lifting-sectional", "Curtain", "Roll-up"};
		
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
			promoMap = new HashMap<String, Double>();
			ArrDoor = new int[]{6900, 9000, 8400, 4000};
			ArrTime = new double[]{0.5, 0.75, 1, 2.5};
			ArrType = new double[]{1.15,1};
			ArrFoundation = new int[]{0,650,3000,1400};
			ArrPanel = new int[]{1200,1600,2500};
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
		public void CalculateHangarCost(HttpServletRequest request) {
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
			//Пытаемся прочитать вход как числа
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
			
			request.setAttribute("doorResult", doorToString[door]);
			request.setAttribute("timeResult", inputTime);
			request.setAttribute("xResult", inputx);
			request.setAttribute("yResult", inputy);
			request.setAttribute("zResult", inputz);
			request.setAttribute("typeResult", typeToString[type]);
			request.setAttribute("foundationResult", foundationToString[foundation]);
			request.setAttribute("formHangarResult",formToString[formHangar]);
			request.setAttribute("promoResult",inputPromo);
			request.setAttribute("panelResult",panelToString[panel]);
			double price = 0;
			//определяем  нужный тип ангара
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
			outputForFile= new String[] {inputx, inputy, inputz, typeToStringEn[type], formToStringEn[formHangar], panelToStringEn[panel], inputTime, foundationToStringEn[foundation], doorToStringEn[door], inputPromo, Double.toString(Math.floor(price/100)*100)}; //заполняем значения для вывода в файл
			request.setAttribute("price", Double.toString(Math.floor(price/100)*100)); //Выводим округлённую итоговую цену ангара
		}
		//функция возвращает коофициент в зависимости от времени постройки
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
		//функция возвращает размер скидки, если верно введён промокод.
		public double getPromo(String promo) {
	        if (promoMap.containsKey(promo)) {
	            return promoMap.get(promo);
	        } else {
	            return 1;
	        }
	    }
	}
	
}