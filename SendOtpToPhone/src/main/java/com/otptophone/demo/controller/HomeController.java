package com.otptophone.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otptophone.demo.service.OtpService;

@RestController
public class HomeController {
	
	@Autowired
	 private OtpService otpService;
	// test api
	@GetMapping("/")
	public String home() {
		return "welcome to spring boot";
	}
	
	@PostMapping("/sendOtp")
	public String sendOtp( @RequestParam String mobileNumber) {
		return otpService.sendOtpToPhone(mobileNumber);
	}
	
	@PostMapping("/verify")
	public String verifyOtp(@RequestParam String otp) {
		return otpService.validateOtp(otp);
		
	}

}
