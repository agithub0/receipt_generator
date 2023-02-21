package com.EIS.Receipt_Generator.controller;

import com.EIS.Receipt_Generator.document.PDFGenerator;
import com.EIS.Receipt_Generator.mailSender.EmailReceipt;
import com.EIS.Receipt_Generator.mapper.DataMapper;
import com.EIS.Receipt_Generator.model.ReceiptInformation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@RestController
public class ReceiptGeneratorController {
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	@Autowired
	private DataMapper dataMapper;
	
	@Autowired
	private EmailReceipt emailReceipt;
	
	final String ACKNOWLEDGEMENT_PATH="Generated_Receipt/Acknowledgement_Receipt.pdf";
	final String OFFICIAL_PATH="Generated_Receipt/Official_Receipt.pdf";
	
	@PostMapping(value = "/generate_receipt")
	public void generateDocument(@RequestBody ReceiptInformation receipt_information) {
		//ReceiptInformation receipt_information= receipt_info_value();
		Context dataContext = dataMapper.setData(receipt_information);
		
		String acknowledgement_receipt = springTemplateEngine.process("Acknowledgement_Receipt_Template",dataContext);
		String official_receipt = springTemplateEngine.process("Official_Receipt_Template", dataContext);
		
		
		pdfGenerator.htmlToPdf(acknowledgement_receipt,ACKNOWLEDGEMENT_PATH);
		pdfGenerator.htmlToPdf(official_receipt,OFFICIAL_PATH);
		 emailReceipt.sendReceiptViaEmail();
		
	}
	
	public ReceiptInformation receipt_info_value() {
		ReceiptInformation receipt_information = new ReceiptInformation();
//		receipt_information.setReceivedFrom("DONG-A PHARMA PHILS. INC.");
//		receipt_information.setAddress("UNIT 2803 ATLANTA CENTRE ILOILO 1500 PHILIPPINES");
//		receipt_information.setPaymentOf("wunghao");
//		receipt_information.setAmountInWords("Ten Thousand");
//		receipt_information.setAmountInNumbers("10000");
//		receipt_information.setBussinessStyleOf("Garima");
//		receipt_information.setDateIssued("20/2/2014");
//		receipt_information.setPermit("CAS");
//		receipt_information.setTin("225125979");
		return receipt_information;
		
	}
}