package com.te.sendSms.service;



import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service
public class SMSServiceImpl implements SMSService{

	@Override
	public HttpResponse<String> sendSms(String apiKey, String numbers, String message) {
				        try {
		            HttpResponse<String> response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
		                    .header("authorization", apiKey)
		                    .header("Content-Type", "application/x-www-form-urlencoded")
		                    .body("variables_values=" + message + "&route=otp&numbers=" + numbers)
		                    .asString();

		            return response;
		        } catch (Exception e) {
		            e.printStackTrace();
		            
		        }
		        return null;
		    }
		


	

}
