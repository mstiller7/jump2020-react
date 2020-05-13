package com.cognixia.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.cognixia.repository.TodoRepository;

@Component
public class ToDoConsumer {
	private static final Logger log = LoggerFactory.getLogger(ToDoConsumer.class);
	
	private TodoRepository todoRepos;
	
	public ToDoConsumer(TodoRepository repository) {
		this.todoRepos = repository;
	}
	
	@RabbitListener(queues = "${todo.amqp.queue}")
	public void processToDo(Todo todo) {
		
		log.info("Consumer> " + todo);
		log.info("ToDo created> " + this.todoRepos.save(todo));
	}
}