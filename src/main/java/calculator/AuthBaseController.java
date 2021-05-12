package calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Класс для работы с "базой" паролей
public class AuthBaseController {
	static File fileBase = new File("/app/src/AuthBase.txt"); //путь до "базы"
	
	//В файле каждая строка это новая учётная запись. Логин и пароль разделенны символом ";"
	
	//Функция для проверки того, есть ли данная учётная запись в базе
	public static boolean checkAuth(String login, String password) {
		
		if (!isCorrectAuth(login, password)) {
			return false;
		}
		
		BufferedReader reader;
		try {
			String line;
			reader = new BufferedReader(new FileReader(fileBase));
			while((line = reader.readLine())!=null) {
				String[] tempArr= line.split(";");
				if (tempArr[0].equals(login) && tempArr[1].equals(password)) {
					reader.close();
					return true;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Функция добавления учётной записи
	public static boolean addAuth(String login, String password) {
		
		if (!isCorrectAuth(login, password)) {
			return false;
		}
		
		BufferedWriter writer;
		try {
			boolean authInBase=checkAuth(login, password);
			writer = new BufferedWriter(new FileWriter(fileBase,true));
			if (authInBase == false) {
				writer.newLine();
				writer.append(login+";"+password);
			}
			writer.close();
			return !authInBase;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Функция изменения учётной записи
	public static boolean changeAuth(String login, String password, String newLogin, String newPassword) {
		
		if (!isCorrectAuth(login, password)||!isCorrectAuth(newLogin, newPassword)) {
			return false;
		}
		
		boolean isCorrectChange = false;
		BufferedReader reader;
		BufferedWriter writer;
		try {
			String line;
			String buffer = "";
			reader = new BufferedReader(new FileReader(fileBase));
			while((line = reader.readLine())!=null) {
				String[] tempArr= line.split(";");
				if (tempArr[0].equals(login) && tempArr[1].equals(password)) {
					buffer+=newLogin+";"+newPassword+"\n";
					isCorrectChange = true;
				} else {
					buffer+=line+"\n";
				}
			}
			reader.close();
			if (isCorrectChange) {
				writer = new BufferedWriter(new FileWriter(fileBase));
				writer.write(buffer.substring(0, buffer.length()-1));
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isCorrectChange;
	}
	
	//Функция удаления учётной записи
	public static boolean deleteAuth(String login, String password) {
		
		if (!isCorrectAuth(login, password)) {
			return false;
		}
		
		boolean isCorrectChange = false;
		BufferedReader reader;
		BufferedWriter writer;
		
		try {
			String line;
			String buffer = "";
			reader = new BufferedReader(new FileReader(fileBase));
			while((line = reader.readLine())!=null) {
				String[] tempArr= line.split(";");
				if (tempArr[0].equals(login) && tempArr[1].equals(password)) {
					isCorrectChange = true;
				} else {
					buffer+=line+"\n";
				}
			}
			reader.close();
			if (isCorrectChange) {
				writer = new BufferedWriter(new FileWriter(fileBase));
				writer.write(buffer.substring(0, buffer.length()-1));
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isCorrectChange;
	}
	
	//Проверка корректности логина и пароля
	public static boolean isCorrectAuth(String login, String password) {
		return !(login==""||password=="");
	}
}
