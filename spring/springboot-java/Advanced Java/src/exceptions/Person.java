package exceptions;

public class Person {

	private int age;

	public int getAge() {
		return age;
	}

	// age can't be negative
	public void setAge(int age) throws Exception {
		
		if (age < 0) {
			throw new Exception("You can't have a negative age!");
		}
		
		this.age = age;
	}
	
}
