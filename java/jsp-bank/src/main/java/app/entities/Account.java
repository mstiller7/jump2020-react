package app.entities;

public class Account {
	
	private String name;
	private String password;
	
	public Account() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Account{" +
		"name='" + name + '\'' +
		", password='" + password + '\'' +
		'}';
	}
}
