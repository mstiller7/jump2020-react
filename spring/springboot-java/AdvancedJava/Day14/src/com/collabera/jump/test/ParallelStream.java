package com.collabera.jump.test;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		for (int i = 0; i < 50000; i++) {
			empList.add(new Employee("A", 20000));
			empList.add(new Employee("B", 3000));
			empList.add(new Employee("C", 15002));
			empList.add(new Employee("D", 7856));
			empList.add(new Employee("E", 200));
			empList.add(new Employee("F", 50000));
		}
		long t1 = System.currentTimeMillis();
		System.out.println("Sequential Stream count: " + empList.stream().filter(e -> e.getSalary() > 15000).count());
		long t2 = System.currentTimeMillis();
		System.out.println("Sequential Stream Time taken:" + (t2 - t1));
		t1 = System.currentTimeMillis();
		System.out.println(
				"Parallel Stream count: " + empList.parallelStream().filter(e -> e.getSalary() > 15000).count());
		t2 = System.currentTimeMillis();
		System.out.println("Parallel Stream Time taken:" + (t2 - t1));
	}
}