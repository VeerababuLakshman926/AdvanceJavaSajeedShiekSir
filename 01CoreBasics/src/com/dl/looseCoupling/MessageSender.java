package com.dl.looseCoupling;

public class MessageSender {
	
	//Interface as Datamember
	private MessageService messageService;

	//constructor using fields
	public MessageSender(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void sendMessage(String message) {
		this.messageService.sendMessage(message);
	}
}
