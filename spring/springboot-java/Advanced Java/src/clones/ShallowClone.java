package clones;

public class ShallowClone {

	public static void main(String args[]) throws CloneNotSupportedException {
		CloneTestS t1 = new CloneTestS();
		t1.a = 100;
		t1.b = 200;
		t1.c.x = 300;
		t1.c.y = 400;

		CloneTestS t2 = (CloneTestS) t1.clone();

		// Creating a copy of object t1 and passing
		// it to t2
		t2.a = 1000;
//		t2.b = 1500;

		// Change in primitive type of t2 will not
		// be reflected in t1 field
		t2.c.x = 3000;
//		t2.c.y = 15;
		
		// Change in object type field will be reflected in both t2 and t1(shallow copy)
		System.out.println(t1.a + " " + t1.b + " " + t1.c.x + " " + t1.c.y);
		System.out.println(t2.a + " " + t2.b + " " + t2.c.x + " " + t2.c.y);

	}
}