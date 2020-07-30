package countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityDAOC implements CityDAO {
	
	List<City> cities;
	
	public CityDAOC() {
		this.cities = new ArrayList<>();
	}
	
	@Override
	public List<City> getCities() {
		
		try {
			
			cities = new ArrayList<>();
			ResultSet rs = Main.db
					.createStatement()
					.executeQuery("select * from city");
			
			while (rs.next()) {
				cities.add(new City(
						rs.getInt("CityID"),
						rs.getInt("CountryID"),
						rs.getString("Name")
				));
			}
			return cities;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public City getCity(int id) {
		
		try {
			
			ResultSet rs = Main.db
					.createStatement()
					.executeQuery("select * from city where CityID = " + id);
			
			if (rs.next()) {
				return new City(
						rs.getInt("CityID"),
						rs.getInt("CountryID"),
						rs.getString("Name")
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public boolean updateCity(int id) {
		
		try {
			
			City c = cities.get(id);
			Scanner stdin = new Scanner(System.in);
			
			System.out.println("Existing city name: ");
			System.out.println(c.getName());
			System.out.println("Enter new city name: ");
			c.setName(stdin.nextLine());
			
			System.out.println("Existing city's country: ");
			System.out.println(c.getCountry());
			System.out.println("Enter city's country: ");
			c.setCountry(stdin.nextInt());
			
			PreparedStatement ps = Main.db.prepareStatement(
					"update city set CountryID = ?, Name = ? where CityID = ?"
			);
			ps.setInt(3, c.getId());
			ps.setInt(1, c.getCountry());
			ps.setString(2, c.getName());
			return ps.executeUpdate() == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	@Override
	public boolean deleteCity(int id) {
		
		try {
			
			return Main.db.prepareStatement(
					"delete  from city where CityID = "
							+ id).executeUpdate() == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}

interface CityDAO {
	
	List<City> getCities();
	
	City getCity(int id);
	
	boolean updateCity(int id);
	
	boolean deleteCity(int id);
	
}