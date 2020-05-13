package TodoApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> Todos = new ArrayList<Todo>();
	private static int TodoCount = 3;
	
	static {
		Todos.add(new Todo(1, "Jack", "Learn Spring Boot", new Date(), false));
		Todos.add(new Todo(2, "Jack", "Learn JPA", new Date(), false));
		Todos.add(new Todo(3, "Jill", "Learn AWS Lambda", new Date(), false));
	}
	
	//retrieve all the todos for a user
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo t : Todos) {
			if (t.getUser().equals(user))
				filteredTodos.add(t);
		}
		return filteredTodos;
	}
	
	//for adding Todo.
	public Todo addTodo(String name, String desc, Date targetDate, boolean isDone) {
		Todo t = new Todo(TodoCount++, name, desc, targetDate, isDone);
		Todos.add(t);
		return t;
	}
	
	//retrieve based on Id.
	public Todo retrieveTodo(int id) {
		for (Todo t : Todos) {
			if (t.getId() == id)
				return t;
		}
		return null;
	}
	
	//update todo based on id
	public Todo updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//delete a todo based on id
	public boolean deleteTodoById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}