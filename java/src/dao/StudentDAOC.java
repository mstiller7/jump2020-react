package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOC implements StudentDAO {
	
	//list is working as a database
	List<Student> students;
	
	public StudentDAOC() {
		students = new ArrayList<>();
	}
	
	//retrieve list of Students from the database
	@Override
	public List<Student> getStudents() {
		Connection c = ConnectionFactory.connect();
		try {
			assert c != null;
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			students = new ArrayList<>();
			
			while (rs.next()) {
				Student s = new Student();
				s.setStudentID(rs.getInt("student_id"));
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				students.add(s);
			}
			return students;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Student getStudent(int id) {
		Connection c = ConnectionFactory.connect();
		try {
			assert c != null;
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE student_id=" + id);
			if (rs.next()) {
				Student s = new Student();
				s.setStudentID(rs.getInt("student_id"));
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				return s;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public boolean updateStudent(Student s) {
		Connection c = ConnectionFactory.connect();
		try {
			assert c != null;
			PreparedStatement ps = c.prepareStatement("UPDATE student SET firstname=?, lastname=? WHERE student_id=?");
			ps.setString(2, s.getFirstname());
			ps.setString(3, s.getLastname());
			ps.setInt(1, s.getStudentID());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteStudent(Student s) {
		// TODO
		return false;
	}
	
}