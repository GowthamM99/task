package com.te.sendSms.controller;




import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sendSms.service.SMSService;

import kong.unirest.HttpResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SMSController {
	
	    private final SMSService smsService;

	    @PostMapping("/send")
	    public String sendSms() {
	        String apiKey = "rYDM4yFHKphJ8L0afjtT1ROGmqBEsAzWbi2NQUZSvlIoeV6gP3YW5nOcm9gE2oTHhjidB0z8DlICpuAG";
	        String numbers = "8197451318,8904410752";
	        String message = "Gowtham here from TYSS";

	       HttpResponse<String> response = smsService.sendSms(apiKey, numbers, message);

	        if (response != null && response.getStatus() == 200) {
	            return "SMS sent successfully!";
	        } else {
	            return "Failed to send SMS. Error: " + response.getBody();
	        }
	    
	}


}
