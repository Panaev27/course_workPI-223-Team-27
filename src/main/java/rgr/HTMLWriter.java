package rgr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import calculator.CreationTable;
import calculator.WriterInFile;

public class HTMLWriter implements CreationTable, WriterInFile {
	
	private String outputPath;//���� �� �����
	
	public HTMLWriter(String path) {
		outputPath = path;
	}

	@Override
	public void write(String forWrite) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputPath)));
			writer.write(formatString(forWrite));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void append(String forWrite) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputPath), true));
			writer.append(formatString(forWrite));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String formatString(String toFormat) {
		toFormat="<html>"+toFormat+"</html>";
		return String.format(toFormat, "<br>");
	}

}
