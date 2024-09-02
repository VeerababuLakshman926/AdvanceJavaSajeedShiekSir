package com.dl.tightCoupling;

public class SMSService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("SMS " + message);
	}

}
