package clones;

public class CloneTestD {

	int x, y;
}

class CloneTestDP implements Cloneable {
	int a, b;

	CloneTestD c = new CloneTestD();

	public Object clone() throws CloneNotSupportedException {
		// Assign the shallow copy to new reference variable t
		CloneTestDP t = (CloneTestDP) super.clone();

		t.c = new CloneTestD();

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}
}