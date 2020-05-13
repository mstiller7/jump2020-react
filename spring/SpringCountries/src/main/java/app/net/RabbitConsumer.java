package app.net;

import app.App;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
	
	@RabbitListener(queues = App.QUEUE)
	public void printMessages(String message) {
		System.out.println("=============");
		System.out.println(message);
		System.out.println("*************");
	}
}
