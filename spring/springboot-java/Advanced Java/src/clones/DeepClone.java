package clones;

public class DeepClone {

	public static void main(String args[]) throws CloneNotSupportedException {
		CloneTestDP t1 = new CloneTestDP();
		t1.a = 110;
		t1.b = 220;
		t1.c.x = 330;
		t1.c.y = 440;

		CloneTestDP t3 = (CloneTestDP) t1.clone();
		t3.a = 1100;

		// Change in primitive type of t3 will not
		// be reflected in t1 field
		t3.c.x = 3300;

		// Change in object type field of t3 will not
		// be reflected in t1(deep copy)
		System.out.println(t1.a + " " + t1.b + " " + t1.c.x + " " + t1.c.y);
		System.out.println(t3.a + " " + t3.b + " " + t3.c.x + " " + t3.c.y);
	}
}