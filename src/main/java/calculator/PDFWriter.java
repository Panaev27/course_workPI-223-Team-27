package calculator;

import java.io.*;
import java.util.stream.Stream;

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

public class PDFWriter {
	

	
    public PDFWriter() {
    	
    }
    public void Create() {
      	
    	Document document = new Document(); //ñîçäàíèå êëàññà Document
		try {
			//  /var/apache-tomcat-9.0.39/webapps/CreatePDF/
			PdfWriter.getInstance(document, new FileOutputStream("/tmp/Check.pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
			 
		document.open(); 
		
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "UTF-8", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = "Hello! You are cool.";
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "This test from Dyomin with respect!";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
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
    	
		 
		//äîáàâëåíèå òàáëèöû
		 PdfPTable table = new PdfPTable(2); //ñîçäàíèå òàáëèöû ñ 4 ñòîëáöàìè
		 addHeader(table);
		 addRows(table);
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    
	    document.close(); //çàêðûòèå è ñîõðàíåíèå äîêóìåíòà PDF
    }
    
private void addRows(PdfPTable table) {
		
		//çàïîëíåíèå òàáëèöû ââîäèìûìè çíà÷åíèÿ â òåêñòîâûå ïîëÿ íà ãëàâíîé ôîðìå
		String cell1 = Calc.radiusGet;
		String cell2 = Calc.heightGet;
				
		table.addCell(cell1);
	    table.addCell(cell2);
		
	    //âûøå äîëæåí áûòü òåêñò íà ðóññêîì ÿçûêå, êàê åãî âûâåñòè ìîæíî ïîñìîòðåòü â ñïðàâêå.
	}

private void addHeader(PdfPTable table) {
	Stream.of("Radius", "Height")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
}
}
