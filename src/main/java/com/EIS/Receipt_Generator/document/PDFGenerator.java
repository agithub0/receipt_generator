package com.EIS.Receipt_Generator.document;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class PDFGenerator {

	public String htmlToPdf(String processedHtml,String pdf_path) {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			
			PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);
			
			DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);
			
			ConverterProperties converterProperties = new ConverterProperties();
			
			converterProperties.setFontProvider(defaultFont);
			
			HtmlConverter.convertToPdf(processedHtml, pdfwriter, converterProperties);
		
			FileOutputStream fout = new FileOutputStream(pdf_path);
			byteArrayOutputStream.writeTo(fout);
			byteArrayOutputStream.close();
			
			byteArrayOutputStream.flush();
			fout.close();
			
			return null;
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}
}

