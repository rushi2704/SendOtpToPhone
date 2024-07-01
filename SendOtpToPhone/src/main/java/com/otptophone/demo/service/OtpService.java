package com.otptophone.demo.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otptophone.demo.configuration.OtpTwilioConfiguration;

@Service
public class OtpService {
	@Autowired
	private OtpTwilioConfiguration otpTwilioConfiguration;
	Map<String,String> otpMap = new HashMap<String,String>();

	public String sendOtpToPhone( String mobileNumber) {
		String otp = generateOtp();
		PhoneNumber reciepientPhoneNumber = new PhoneNumber(mobileNumber);
		PhoneNumber senderPhoneNumber = new PhoneNumber(otpTwilioConfiguration.getPhoneNumber());
		String msgBody = "your one time password is :"+ otp;
		Message  message=Message.creator(reciepientPhoneNumber,senderPhoneNumber,msgBody).create();
		otpMap.put(msgBody,otp);
		return "opt send successfully ";
	}

	private String generateOtp() {
		int otp = (int) (Math.random() * 1000000);
		
		return String.format("%06d", otp);
	}

	public String validateOtp(String otp) {
		Set<String> keys = otpMap.keySet();
		String value = null;
		for(String key: keys) {
			value = otpMap.get(key);
		}
		if(value.equals(otp))
			return "otp validated success";
			else
				return "invalid otp";
	
	}

}
