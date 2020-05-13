package app.net;

import app.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
	@Autowired
	CountryRepo repo;
	
	public Country createCountry(Country c) {
		return repo.save(c);
	}
	
	public List<Country> getCountries() {
		return repo.findAll();
	}
	
	public Country getCountry(String name) { return repo.findByName(name); }
	
}