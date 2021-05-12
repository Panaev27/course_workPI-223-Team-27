package calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AuthBaseController {
	static File fileBase = new File("/app/src/AuthBase.txt");
	
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
	
	public static boolean changeAuth(String login, String password, String newLogin, String newPassword) {
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
	
	public static boolean isCorrectAuth(String login, String password) {
		return (login==""||password=="");
	}
	
	public static String getAllAuths() {
		BufferedReader reader;
		String lines="";
		try {
			String line;
			reader = new BufferedReader(new FileReader(fileBase));
			while((line = reader.readLine())!=null) {
				lines+=line;
				
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
}
