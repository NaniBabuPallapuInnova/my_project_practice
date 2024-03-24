package com.example.controller;

import com.example.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private MessageStore messageStore;

	@Override
	public String execute() {

		this.messageStore = new MessageStore();

		return "Success";
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}
}
