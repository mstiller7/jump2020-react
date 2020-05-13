package app.net;

import java.util.List;
import javax.validation.Valid;

import app.Country;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController
{
	@Autowired
	CountryService serv;
	
	@GetMapping("/countries")
	List<Country> getCountries() {
		return serv.getCountries();
	}
	
	@PostMapping("/country")
	Country createCountry(@Valid @RequestBody Country country) {
		return serv.createCountry(country);
	}
	
	@Autowired
	RabbitTemplate template;
	
	@GetMapping("/publish")
	public boolean publishMessage(@RequestParam String queue, @RequestParam String message) {
		template.convertAndSend(queue, message);
		return true;
	}
	
}
