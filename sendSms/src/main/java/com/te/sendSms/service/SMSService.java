package com.te.sendSms.service;

import kong.unirest.HttpResponse;

public interface SMSService {

	HttpResponse<String> sendSms(String apiKey, String numbers, String message);

	

	

}
