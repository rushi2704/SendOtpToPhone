package com.otptophone.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.otptophone.demo.configuration.OtpTwilioConfiguration;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SendOtpToPhoneApplication {

	
	@Autowired
	private OtpTwilioConfiguration otpTwilioConfiguration;
	
	@PostConstruct
	public void setup() {
		
		Twilio.init(otpTwilioConfiguration.getAccountSid(), otpTwilioConfiguration.getauthToken());
	}
	public static void main(String[] args) {
		SpringApplication.run(SendOtpToPhoneApplication.class, args);
	}
	
	

}
