package countries;

public class Country {
	
	private int id;
	private String name;
	private int pop;
	
	public Country() {
	}
	
	public Country(int id, String name, int pop) {
		this.id = id;
		this.name = name;
		this.pop = pop;
	}
	
	public int getId() {
		return id;
	}
	
	// no ID setter, as it's the primary key.
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPop() {
		return pop;
	}
	
	public void setPop(int pop) {
		this.pop = pop;
	}
	
	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pop=" + pop +
				'}';
	}
	
}
