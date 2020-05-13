import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// load the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MrBean service = (MrBean) context.getBean("helloWorldService");
		String message = service.sayHello();
		System.out.println(message);
		
		//set a new name
		service.setName("Spring Example");
		message = service.sayHello();
		System.out.println(message);
		
		//instantiate the StudentService Bean
		StudentBean studentService = (StudentBean)
				context.getBean("studentService");
		int id = studentService.getId();
		String fname = studentService.getFname();
		String lname = studentService.getLname();
		System.out.println("Student Id: " + id + "\nStudent Name: " + fname + " " +
				lname);
		//set a new name
		studentService.displayStudentService(9, "Justin", "Trudeau");
	}
}