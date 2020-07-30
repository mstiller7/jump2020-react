package countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryDAOC implements CountryDAO {
	
	List<Country> countries;
	
	public CountryDAOC() {
		this.countries = new ArrayList<>();
	}
	
	@Override
	public List<Country> getCountries() {
		
		try {
			
			countries = new ArrayList<>();
			ResultSet rs = Main.db
					.createStatement()
					.executeQuery("select * from country");
			
			while (rs.next()) {
				countries.add(new Country(
						rs.getInt("CountryID"),
						rs.getString("CountryName"),
						rs.getInt("Population")
				));
			}
			return countries;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public Country getCountry(int id) {
		
		try {
			
			ResultSet rs = Main.db
					.createStatement()
					.executeQuery("select * from country where CountryID = " + id);
			
			if (rs.next()) {
				return new Country(
						rs.getInt("CountryID"),
						rs.getString("CountryName"),
						rs.getInt("Population")
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public boolean updateCountry(int id) {
		
		try {
			
			Country c = countries.get(id);
			Scanner stdin = new Scanner(System.in);
			
			System.out.println("Existing city name: ");
			System.out.println(c.getName());
			System.out.println("Enter new city name: ");
			c.setName(stdin.nextLine());
			
			System.out.println("Existing city population: ");
			System.out.println(c.getPop());
			System.out.println("Enter city population: ");
			c.setPop(Integer.parseInt(stdin.nextLine()));
			
			PreparedStatement ps = Main.db.prepareStatement(
					"update country set CountryName = ?, Population = ? where CountryID = ?"
			);
			ps.setInt(3, c.getId());
			ps.setString(1, c.getName());
			ps.setInt(2, c.getPop());
			return ps.executeUpdate() == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	@Override
	public boolean deleteCountry(int id) {
		
		try {
			
			return Main.db.prepareStatement(
					"delete  from country where CountryID = "
							+ id).executeUpdate() == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}

interface CountryDAO {
	
	List<Country> getCountries();
	
	Country getCountry(int id);
	
	boolean updateCountry(int id);
	
	boolean deleteCountry(int id);
	
}