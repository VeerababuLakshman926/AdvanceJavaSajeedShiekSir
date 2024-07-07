package com.dl.tightCoupling;

public class MessageSender {
	
	// we are creating 2 instances here
	private SMSService smsService = new SMSService();
	private EmailService emailService = new EmailService();
	
	public void sendSMS(String message) {
		this.smsService.sendMessage(message);
	}
	
	public void sendEmail(String message) {
		this.emailService.sendMessage(message);
	}
	
	
}
