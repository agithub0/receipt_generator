package com.EIS.Receipt_Generator.mailSender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailReceipt {

	@Autowired
	private RestTemplate restTemplate;
	public void sendReceiptViaEmail(String customer_Email) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        
        File receiptFile=new File("Generated_Receipt/Acknowledgement_Receipt.pdf");
        MultiValueMap<String, String> receiptFileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
                .builder("form-data")
                .name("file")
                .filename(receiptFile.getName())
                .build();
        receiptFileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        byte[] receiptFileContent=null;
		try {
			receiptFileContent = Files.readAllBytes(receiptFile.toPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        HttpEntity<byte[]> fileEntity = new HttpEntity<>(receiptFileContent, receiptFileMap);

        try {
			System.out.println(Files.readAllBytes(receiptFile.toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*different methods*/
       
        MultiValueMap<String, Object> emailRequestBody = new LinkedMultiValueMap<>();
        emailRequestBody.add("attachment", fileEntity);
        emailRequestBody.add("recipient", customer_Email);
        emailRequestBody.add("subject", "Acknowledgement_Receipt");
        emailRequestBody.add("msgBody", "Here is you Acknowledgement_Receipt");
        

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(emailRequestBody, headers);
        ResponseEntity<String> response=null;
//        try {
//            response = restTemplate.exchange(
//                    "http://localhost:8081/sendMailWithAttachment",
//                    HttpMethod.POST,
//                    requestEntity,
//                    String.class);
//            
//        } catch (HttpClientErrorException e) {
//        	System.out.println("Error");
//            e.printStackTrace();
//        }
//        System.out.println(response);
        }

	}
