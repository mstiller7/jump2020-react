package countries;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static Connection db;
	
	public static void main(String[] args) {
		
		// make and hold a DB connection.
		db = ConnectionFactory.connect();
		
		// instantiate the country & city concrete objects.
		CountryDAOC countryDAOC = new CountryDAOC();
		List<Country> countries = countryDAOC.getCountries();
		
		CityDAOC cityDAOC = new CityDAOC();
		List<City> cities = cityDAOC.getCities();

		// Objective 1: Print all countries along with their cities.
		for (Country c : countries) {
			
			System.out.println("The country of " + c.getName() +
					" (" + c.toString() + ") " +
					" contains the following cities:");
			
			int id = c.getId();
			// search the cities table for this id and print
			// any that match
			
			for (City c2: cities) {
				
				if (c2.getCountry() == id) {
					System.out.print(c2.getName() + " : ");
					System.out.println(c2.toString());
				}
				
			}
			
		}
		
		Scanner stdin = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Enter a country ID to be updated: ");
			int id = stdin.nextInt();
			countryDAOC.updateCountry(id);
			System.out.println("The country was updated:");
			System.out.println(countries.get(id).toString());
			
		}
		
	}
	
}
