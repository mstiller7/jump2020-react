package assignments;

import java.io.*;

class ArraySerializer {

	public static void main(String[] args) {

		testSerialize();
		testDeserialize();

	}

	static void testSerialize() {

		EmployeeSerializable[] es = new EmployeeSerializable[3];

		es[0] = new EmployeeSerializable("Tom Nook", "123 Nook Ave.", 111111111, 1);
		es[1] = new EmployeeSerializable("Isabelle", "124 Nook Ave.", 222222222, 2);
		es[2] = new EmployeeSerializable("K.K. Slider", "125 Nook Ave.", 333333333, 3);

		try {

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emps.ser"));
			out.writeObject(es);
			out.close();
			System.out.println("Saved to: emps.ser");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void testDeserialize() {

		EmployeeSerializable[] es = null;

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("emps.ser"));
			es = (EmployeeSerializable[]) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (EmployeeSerializable e : es) {
			System.out.println("Deserialized Employee:");
			System.out.println("Name: " + e.name);
			System.out.println("Address: " + e.address);
			System.out.println("SSN: " + e.SSN);
			System.out.println("Number: " + e.number);
		}

	}

}

class EmployeeSerializable implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name, address;
	public int SSN;
	public int number;

	public EmployeeSerializable(String name, String address, int sSN, int number) {
		super();
		this.name = name;
		this.address = address;
		this.SSN = sSN;
		this.number = number;
	}

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " at " + address);
	}

}