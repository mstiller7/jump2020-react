package interfaces;

public abstract class Shape {
	
	private String color;
	
	public Shape(String color) {
		this.color = color;
		
	}
	
	public void setColor(String s) {
		this.color = s;
	}
	
	public String getColor() {
		return this.color;
		
	}
	
	// abstract methods
	public abstract double area();
	public abstract double perimeter();
	
	// implemented, but can be overridden.
	public void greeting() {
		System.out.println("i am a " + color + " shape.");
	}

}
