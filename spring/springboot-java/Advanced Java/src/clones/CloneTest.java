package clones;

public class CloneTest {
	int x, y;
}

class CloneTestS implements Cloneable {
	int a;
	int b;
	CloneTest c = new CloneTest();

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}