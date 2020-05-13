package com.cognixia;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "firstqueue")
	public void printMessages(String message) {
		System.out.println("=============");
		System.out.println(message);
		System.out.println("*************");
	}
}
