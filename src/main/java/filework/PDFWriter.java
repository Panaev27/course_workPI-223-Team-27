package filework;

import java.io.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter implements WriterInFile {
	

	
    public PDFWriter() {
    	
    }
    public void write(String[] forWrite) {
      	
    	Document document = new Document(); //Создаём документ
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(new File(PDFWriter.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()).getParent()+"/Hangar.pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
			 
		document.open(); 
		
		BaseFont times = null;//Создаём шрифт
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "UTF-8", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		//Заполняем текстом
		String string_pdf = "Your hangar parametres";
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
    	
		 
		//Создаём таблицу с 2 столбцами
		 PdfPTable table = new PdfPTable(2); 
		 addTableCells(table, forWrite);
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    
	    document.close();
    }
    
    //Заполнение таблицы
    private void addTableCells(PdfPTable table, String[] forWrite) {
		
		//1 столбец заполняет названиями, 2 столбец заполняется значением
    	String[] columnTitles= {"Lenght", "Width", "Height", "Type", "Form", "Panel", "Time", "Foundation", "Door", "Promo", "Price"};
		for (int i=0;i<forWrite.length;i++) {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitles[i]));
	        table.addCell(header);
			table.addCell(forWrite[i]);
		}
	}
}
