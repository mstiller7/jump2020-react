package com.collabera.jump.test;

public class Employee {

	private String name;
	private int salary;
	
	public Employee(String name, int sal) {
		// TODO Auto-generated constructor stub
		
		this.name = name;
		this.salary = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
