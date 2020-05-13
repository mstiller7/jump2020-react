package CityCountryServer;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Country {
	
	private static ArrayList<Country> countries;
	
	public static void init() {
		
		countries = new ArrayList<>();
		
		countries.add(new app.Country("USA", "Washington D.C.", 330149796));
		countries.add(new app.Country("Canada", "Ottawa", 37665546));
		countries.add(new app.Country("Mexico", "Mexico City", 128620609));
		countries.add(new app.Country("Greenland", "Nuuk", 56770));
		countries.add(new app.Country("Iceland", "Reykjavik", 340739));
		
	}
	
	public static ArrayList<Country> getCountries() {
		return countries;
	}
	
	@Id
	private String name;
	private String capital;
	private int population;
	
	public Country(String name, String capital, int population) {
		this.name = name;
		this.capital = capital;
		this.population = population;
	}
	
	public Country() {
	}
	
	public String getName() {
		return name;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public int getPopulation() {
		return population;
	}
	
}