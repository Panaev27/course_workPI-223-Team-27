package calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AuthBaseController {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
