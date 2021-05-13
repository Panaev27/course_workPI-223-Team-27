package calcTest;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import filework.PDFWriter;

public class PdfWriterTest {
	@Test
    public void testPdf() {

		PDFWriter PDF = new PDFWriter();
		String[] outputForFile= new String[] {"1", "1", "1", "hi", "hi", "hi", "time", "fond", "door", "promo", "price, he-he"};
		PDF.write(outputForFile);
		assertTrue(new File(new File(new File(PDFWriter.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()).getParent()+"/Hangar.pdf").exists());  
    }

}