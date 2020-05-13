package dao;

public class Student {
	
	private int StudentID;
	private String firstname;
	private String lastname;
	
	public Student() {
	}
	
	public Student(int studentID, String firstname, String lastname) {
		StudentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getStudentID() {
		return StudentID;
	}
	
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"StudentID=" + StudentID +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}
}
