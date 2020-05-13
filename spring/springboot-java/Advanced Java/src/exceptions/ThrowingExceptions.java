package exceptions;

public class ThrowingExceptions {

	public static void methodA() throws Exception {

		throw new Exception("This is an exception from methodA.");

	}

	public static void methodB() throws Exception {

		methodA();

		System.out.println("Hello from methodB.");

	}

	public static void main(String[] args) {

		System.out.println("Attempt running methodB;");
		
		try {
			methodB();
		} catch (Exception e) {
			
			System.out.println("methodB threw an exception!");

		}

		
		Person p = new Person();
		try {
			p.setAge(-4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
