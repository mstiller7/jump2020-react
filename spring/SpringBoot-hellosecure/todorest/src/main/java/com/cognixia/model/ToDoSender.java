package com.cognixia.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {
	@Bean
	public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, ToDoProducer producer) {
		return args -> {
			Todo todo = new Todo();
			todo.setDes("workout!");
			todo.setDone(false);
			todo.setTargetDate(new Date());
			todo.setUser("John");
			producer.sendTo(destination, todo);
		};
	}
}