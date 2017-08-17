package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;

@SpringBootApplication
public class BotLineProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotLineProjectApplication.class, args);
	}

	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		System.out.println("event: " + event);
		if (event.getMessage().getText() == "Hi" || event.getMessage().getText().equals("Hi")) {
			return new TextMessage("Hello, How are you?");
		} else {
			return new TextMessage(event.getMessage().getText());
		}
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		System.out.println("event: " + event);
	}
}
