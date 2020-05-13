package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCities {
	
	@GetMapping("/cities")
	public String getCities() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("The following cities are currently present: ");
		
		for (Country c : Country.getCountries()) {
			sb.append(c.getCapital());
		}
		
		return sb.toString();
		
	}
	
}
