package CountryClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryServiceController
{
	Country unitedStates = new Country("United States", "Washington D.C.", 327000000);
    Country unitedKingdom = new Country("United Kingdom", "London", 69000000);
    Country france = new Country("France", "Paris", 68000000);
    Country spain = new Country("Spain", "Madrid", 47000000);
    Country germany = new Country("Germany", "Berlin", 83000000);
    
    Country country = new Country();
    List<Country> countryList = new ArrayList<>(Arrays.asList(unitedStates, unitedKingdom, france, spain, germany));

	@Value("${server.port}")
	private int port;

	@GetMapping("/hello")
	public String greeting()
	{
		return "Hello from EurekaClient! from port:   " + port;
	}
	
	@GetMapping("/Countries")
	
	public String getAllCitiesAndCountries()
	{      
		String resultString = "Country List) \n";
	   	
    	for (Country c: countryList)
    	{
    		String temp = "<---> Country: " + c.getName()+ " \n";
    		resultString += temp;
    	}
    	return resultString;
	}
	
	@GetMapping("/CitiesAndCountries")
	public List<Country> getAllCountries()
	{  	
		
    	return countryList;
	}
	
}
