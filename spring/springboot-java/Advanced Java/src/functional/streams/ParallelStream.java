package functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ParallelStream {
	
	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		for (int i = 0; i < 100; i++) {
			
			empList.add(new Employee("A", 20000));
			empList.add(new Employee("B", 3000));
			empList.add(new Employee("C", 15002));
			empList.add(new Employee("D", 7856));
			empList.add(new Employee("E", 200));
			empList.add(new Employee("F", 50000));
			
		}
		
		// find the min. and max. salaries of the employees
		// sort the employees in asc. order
		
		long time = System.currentTimeMillis();
		
		int minSalary = empList.stream() // first, get the stream
				// next, we want the 'minimum' of the comparison
				// between the objects in the stream, operating
				// on the getSalary() return value.
				.min(Comparator.comparingInt(Employee::getSalary))
				.get() 				// get the Employee, then...
				.getSalary();		// get their salary
		System.out.println("The minimum salary is: $" + minSalary);
		System.out.println("([Sequential Stream] computed in " + (System.currentTimeMillis() - time) + "ms.)");

		time = System.currentTimeMillis();
		int maxSalary = empList.parallelStream().max((e1, e2) -> e1.getSalary() - e2.getSalary()).get().getSalary();
		System.out.println("The minimum salary is: $" + maxSalary);
		System.out.println("([Parallel Stream] computed in " + (System.currentTimeMillis() - time) + "ms.)");
		
//		long t1 = System.currentTimeMillis();
//		System.out.println("Sequential Stream count: "
//				+ empList.stream()
//				.filter(e -> e.getSalary() > 15000).count());
//		
//		long t2 = System.currentTimeMillis();
//		System.out.println("Sequential Stream Time taken: " + (t2 - t1));
//		
//		t1 = System.currentTimeMillis();
//		System.out.println("Parallel Stream count: " 
//				+ empList.parallelStream()
//				.filter(e -> e.getSalary() > 15000).count());
//		
//		t2 = System.currentTimeMillis();
//		System.out.println("Parallel Stream Time taken: " + (t2 - t1));
	}

}