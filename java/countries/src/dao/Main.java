package dao;

public class Main {
	public static void main(String[] args) {
		StudentDAOC concrete = new StudentDAOC();
		
		//print all Students
		for (Student s : concrete.getStudents()) {
			System.out.println(s.toString());
		}
	}
}