package com.cjc.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.cong.GeneratePdfReport;
import com.cjc.model.City;
import com.cjc.serv.ICityService;   
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class MyController {
	
    @Autowired
    private ICityService cityService;
    @Autowired
   private 	JavaMailSender sender;


    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public String citiesReport() throws MessagingException {

    	List<City> cities =  cityService.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

         ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
        
        
        
        
     // TODO Auto-generated method stub
    	//	SimpleMailMessage mail=new SimpleMailMessage();
    		MimeMessage msg=sender.createMimeMessage();
    		MimeMessageHelper mail=new MimeMessageHelper(msg,true);
    		try {
    		mail.setTo("gorakshbhoirkar36@gmail.com");
    		mail.setFrom("gorakshbhoirkar36@gmail.com");
    		mail.setSubject("SpringBoot Mail");
    		mail.setText("Welcome to my company Name Password");
    		
    		//ClassPathResource file=new ClassPathResource("res.pdf");
    		FileSystemResource file=new FileSystemResource("F:\\ad.pdf");
    		mail.addAttachment("ad.pdf",file);
    		}
    		catch (MessagingException me) {
    			// TODO: handle exception
    			System.out.println(me.getMessage());
    		}
    		sender.send(msg);
    		//dao.save(t);
    		
    		return "mail send successfully";
    }

		
	/*
	 * @GetMapping("/getmail") public String addTrainee() throws MessagingException
	 * { // TODO Auto-generated method stub // SimpleMailMessage mail=new
	 * SimpleMailMessage(); MimeMessage msg=sender.createMimeMessage();
	 * MimeMessageHelper mail=new MimeMessageHelper(msg,true); try {
	 * mail.setTo("jaybhoirkar95@gmail.com");
	 * mail.setFrom("jaybhoirkar95@gmail.com"); mail.setSubject("SpringBoot Mail");
	 * mail.setText("Welcome to my company Name Password");
	 * 
	 * //ClassPathResource file=new ClassPathResource("res.pdf"); FileSystemResource
	 * file=new FileSystemResource("F:\\response.pdf");
	 * mail.addAttachment("response.pdf",file); } catch (MessagingException me) { //
	 * TODO: handle exception System.out.println(me.getMessage()); }
	 * sender.send(msg); //dao.save(t);
	 * 
	 * return "mail send successfully"; }
	 */

}
