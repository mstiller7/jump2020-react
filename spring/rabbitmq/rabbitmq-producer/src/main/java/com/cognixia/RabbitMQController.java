package com.cognixia;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	@Autowired
	RabbitTemplate template;
	
	@GetMapping("/publish")
	public boolean publishMessage(@RequestParam String queue, @RequestParam String message) {
		template.convertAndSend(queue, message);
		return true;
	}
}
