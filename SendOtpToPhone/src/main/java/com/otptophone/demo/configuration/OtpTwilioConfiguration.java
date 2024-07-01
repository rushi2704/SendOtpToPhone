package com.otptophone.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class OtpTwilioConfiguration {
	
	private String accountSid;
	private String authToken;
	private String phoneNumber;
	
	// this is configuration class 
	
	public OtpTwilioConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpTwilioConfiguration(String accountSid, String authToken, String phoneNumber) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.phoneNumber = phoneNumber;
	}
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getauthToken() {
		return authToken;
	}
	public void setauthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "OtpTwilioConfiguration [accountSid=" + accountSid + ", authToken=" + authToken + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	

}
