package com.dl.tightCoupling;

public class Client {

	public static void main(String[] args) {
		
		MessageSender messageSender = new MessageSender();
		messageSender.sendSMS("Hello sms");
		messageSender.sendEmail("hello Email");
	}
}
