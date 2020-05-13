package TodoException;

import TodoApp.Todo;
import TodoApp.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TodoNotFoundException extends RuntimeException {
	@Autowired
	private TodoService ts;
	
	public TodoNotFoundException(String msg) {
		super(msg);
	}
	
	//Exception Handling
	@GetMapping(path = "/users/dummy-service")
	public Todo errorService() {
		throw new RuntimeException("Some Exception Occured");
	}
	
	@GetMapping("/users/{name}/Todos/{id}")
	public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
		Todo t = ts.retrieveTodo(id);
		if (t == null) {
			throw new TodoNotFoundException("Todo Not Found");
		}
		return t;
	}
}


