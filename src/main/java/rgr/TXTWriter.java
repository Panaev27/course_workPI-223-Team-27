package rgr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TXTWriter implements Formater, WriterInFile {
	
	private String outputPath;//���� �� �����
	
	public TXTWriter(String path) {
		outputPath = path;
	}
	
	//���������� ���� ������ �������
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
	
	//��������� ���� ������ �������
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
		//��������
	}
	
	//����������� ��� ������ �����(��������� ������� ������ %1$s)
	@Override
	public String formatString(String toFormat) {
		return String.format(toFormat, System.lineSeparator());
	}
}