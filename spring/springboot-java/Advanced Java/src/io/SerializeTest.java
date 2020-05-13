package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTest {

	public static void main(String[] args) {
		EmployeeSerial e = new EmployeeSerial();
		e.name = "John Smith";
		e.address = "16th Avenue, Hampstead Drive";
		e.SSN = 11122333;
		e.number = 101;
		try {
			FileOutputStream fileOut = new FileOutputStream("myTestSerial.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in myTestSerial.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
