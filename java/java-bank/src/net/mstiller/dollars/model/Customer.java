package net.mstiller.dollars.model;

public class Customer {
	
	public String name, address, phone;
	
	public Customer(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customer{" +
		"name='" + name + '\'' +
		", address='" + address + '\'' +
		", phone=" + phone + '\'' +
		'}';
	}
}
