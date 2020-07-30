package dao;

import java.util.List;

public interface StudentDAO {
	
	public List<Student> getStudents();
	public Student getStudent(int id);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	
}
