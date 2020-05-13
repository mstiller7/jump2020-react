package app.net;

import app.App;
import app.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class  CountryConsumer {
	private static final Logger log = LoggerFactory.getLogger(CountryConsumer.class);
	
	private CountryRepo countries;
	
	public CountryConsumer(CountryRepo repo) {
		this.countries = repo;
	}
	
	@RabbitListener(queues = App.QUEUE)
	public void processToDo(Country country) {
		
		log.info("Consumer > " + country);
		log.info("Country created > " + this.countries.save(country));
	}
}