package TodoApp;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	
	@NotNull
	private String user;
	
	@Size(min = 9, message = "Enter at least 10 characters.")
	private String des;
	private Date targetDate;
	private boolean done;
	
	public Todo(int id, String user, String des, Date targetDate, boolean done) {
		this.id = id;
		this.user = user;
		this.des = des;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getDes() {
		return des;
	}
	
	public Date getTargetDate() {
		return targetDate;
	}
	
	public boolean isDone() {
		return done;
	}
	
	
}