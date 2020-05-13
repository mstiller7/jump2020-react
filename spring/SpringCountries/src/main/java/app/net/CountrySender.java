package app.net;

import app.App;
import app.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountrySender {
	@Bean
	public CommandLineRunner sendToDos(@Value(App.QUEUE) String destination, CountryProducer producer) {
		return args -> {
			Country c = new Country(
					"Atlantis",
					"Metropolis",
					700
			);
			producer.sendTo(destination, c);
		};
	}
}