package countries;

public class City {
	
	private int id;
	private int country;
	private String name;
	
	public City() {
	}
	
	public City(int id, int country, String name) {
		this.id = id;
		this.country = country;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	// no ID setter, as it's the primary key.
	
	public int getCountry() {
		return country;
	}
	
	public void setCountry(int country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", country=" + country +
				", name='" + name + '\'' +
				'}';
	}
	
}
