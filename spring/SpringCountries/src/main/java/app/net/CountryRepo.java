package app.net;

import app.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryRepo extends JpaRepository<Country, Integer> {
	
	Country findByName(String name);
	
}

