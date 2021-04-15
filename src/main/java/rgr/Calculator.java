package rgr;

import java.util.HashMap;

public class Calculator {
	
	public HashMap<String, Double> promoMap; //�������� ���������
	int[] ArrDoor; //�����
	double[] ArrTime; //���� ����������
	double[] ArrType; //��� �������������
	int[] ArrFoundation; //���������
	int[] ArrPanel; //������
	
	//������������� ��������
	public Calculator() {
		ArrDoor = new int[]{6900, 9000, 8400, 4000};//�����
		ArrTime = new double[]{0.5, 0.75, 1, 2.5}; //���� ����������
		ArrType = new double[]{1.15,1}; //��� �������������
		ArrFoundation = new int[]{0,650,3000,1400}; //���������
		ArrPanel = new int[]{1200,1600,2500}; //������
		promoMap = new HashMap<String, Double>();
		promoMap.put("Romashka", 0.9);
		promoMap.put("sudo getZachet", 0.5);
		promoMap.put("Kaz", 0.85);
		promoMap.put("Demin", 3.0);
		promoMap.put("1", 0.999);
	}
	
	public double CalculateHangarCost(int door, int time, double x, double y, double z, int type, int foundation, int formHangar, String promo, int panel) {
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
		return price;
	}
	//���� ���� ���������
	
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
	
	//�������� ������ �� integer
	public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	//�������� ������ �� double
	public static boolean isDouble(String str) {
        try {
        	Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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