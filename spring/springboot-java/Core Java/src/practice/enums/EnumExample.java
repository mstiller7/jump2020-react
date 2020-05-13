package practice.enums;

public class EnumExample {

	
	public enum Colors {
		RED,
		BLUE,
		YELLOW,
		GREEN,
		PURPLE,
		PINK,
		ORANGE
	}
	
	public static void main(String[] args) {
		
		Colors c = Colors.GREEN;
		
		System.out.println(c.ordinal());
		
		
	}
	
}
