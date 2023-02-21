package com.EIS.Receipt_Generator.model;

import java.time.LocalDate;
import java.util.Random;

import lombok.Data;
@Data
public class ReceiptInformation {
	private LocalDate date=LocalDate.now();
	private String amountInWords;
	
	//seller registered address -  Heading
    private String seller_reg_address;
    //seller tin  -Heading
    private String seller_tin;
    //seller business  style  - Heading
    private String seller_buisness_style;
    //seller's accrediationid
    private String seller_accreditation;
    //customer registered name
    private String buyer_reg_nm;
    //customer tin
    private String buyer_tin;
    //customer address
    private String buyer_reg_address;
    //customer buisness style
    private String buyer_buisness_style;
    //random number
    private String pwdAmt;
    //payment details -  line items
    private String payment_name;
    //payment details  - line items
    private String payment_qty;
    //payment  details  - line items
    private String payment_unit_cost;
    //payment details - line items
    private String payment_sales_amt;
    //booking date time -  static
    private String bookingDateTime;
    //total  sales- invoice  data - totnetsales
    private String total_sales;
    //vat amt - invoice data
    private String vatAmt;
    //less  PWD/SC discount
    private String discount_scAmt;
    //less  PWD/SC discount
    private String discount_pwdAmt;
    //withhold income  -  invoice data
    private String withholdIncome;
    //net  amt pay -  invoice  data
    private String netAmtPay;
    //total net sale after discount
    private String totNetSalesAftDisct;
    //permit unique id
    private String permit;
    //sequence no.
    private int seq_no=setSeq_no();
    //osca/pwd
    private String osc_pwd_no;
    //ptu
    private String ptu_no;
    
    public int setSeq_no() {
    	Random rand = new Random();
    	return rand.nextInt(100000);
    }
    
    
	

}
