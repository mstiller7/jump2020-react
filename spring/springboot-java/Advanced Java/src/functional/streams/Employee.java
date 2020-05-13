package functional.streams;

public class Employee {
	
	private int salary;
	private String name;

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}