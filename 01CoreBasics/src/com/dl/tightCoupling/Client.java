package com.dl.tightCoupling;

public class Client {

	public static void main(String[] args) {
		
		MessageSender messageSender1 = new MessageSender(new SMSService());
		MessageSender messageSender2 = new MessageSender(new EmailService());
		
		messageSender1.sendMessage("Sms hello");
		messageSender2.sendMessage("Email Hello");
	}
}
