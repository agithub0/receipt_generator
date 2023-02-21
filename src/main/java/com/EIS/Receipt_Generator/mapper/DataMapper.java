package com.EIS.Receipt_Generator.mapper;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.EIS.Receipt_Generator.model.ReceiptInformation;

	@Service
	public class DataMapper {

		public Context setData( ReceiptInformation receipt_information) {
			
			Context context = new Context();
			context.setVariable("receipt_information", receipt_information);
			return context;
		}
	}
