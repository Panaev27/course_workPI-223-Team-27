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
			PdfWriter.getInstance(document, new FileOutputStream(new File(new File(PDFWriter.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()).getParent()+"/Hangar.pdf"));
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
    	
		 
		//äîáàâëåíèå òàáëèöû
		 PdfPTable table = new PdfPTable(2); //ñîçäàíèå òàáëèöû ñ 4 ñòîëáöàìè
		 //addHeader(table);
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
    	String[] columnTitles= {"Lenght", "Width", "Height", "Type", "Form", "Panel", "Time", "Foundation", "Door", "Promo", "Price"};
		for (int i=0;i<Calculator.outputForFile.length;i++) {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitles[i]));
	        table.addCell(header);
			table.addCell(Calculator.outputForFile[i]);
			
		}
		
	    //âûøå äîëæåí áûòü òåêñò íà ðóññêîì ÿçûêå, êàê åãî âûâåñòè ìîæíî ïîñìîòðåòü â ñïðàâêå.
	}

private void addHeader(PdfPTable table) {
	Stream.of("Lenght", "Width", "Height", "Type", "Form", "Panel", "Time", "Foundation", "Door", "Promo", "Price")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
}
}
