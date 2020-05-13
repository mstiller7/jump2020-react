package io;

import java.io.Serializable;

public class EmployeeSerial implements Serializable {


	private static final long serialVersionUID = -1127339999582616045L;
	public String name, address;
	public transient int SSN;
	public int number;
	
	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " at " + address);
	}
	
}
