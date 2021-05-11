package calculator;

import java.io.*;

public class WriteInFile {
	static File fileBase = new File("/app/src/AuthBase.txt");
	
	public static boolean checkAuth(String login, String password) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getAuth() {
		BufferedReader reader;
		String lines = "";
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
	
	public static boolean addAuth(String login, String password) {
		BufferedWriter writer;
		BufferedReader reader;
		try {
			String line;
			boolean authInBase=false;
			reader = new BufferedReader(new FileReader(fileBase));
			while((line = reader.readLine())!=null) {
				String[] tempArr= line.split(";");
				if (tempArr[0].equals(login) && tempArr[1].equals(password)) {
					authInBase = true;
				}
			}
			reader.close();
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
}
