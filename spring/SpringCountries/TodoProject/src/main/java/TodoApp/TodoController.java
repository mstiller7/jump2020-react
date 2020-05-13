package TodoApp;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TodoController {
	@Autowired
	private TodoService ts;
	
	//Retrieve all todos of a user
	@GetMapping("/users/{name}/Todos")
	public List<Todo> retrieveTodos(@PathVariable String name) {
		return ts.retrieveTodos(name);
	}
	
	//Retrieve todos of a user by id
	@GetMapping(path = "/users/{name}/Todos/{id}")
	public Todo retrieveTodo(@PathVariable String name, @PathVariable int id) {
		return ts.retrieveTodo(id);
	}
	
	//Add a todos to a user by id
	@Cacheable("Todos")
	@PostMapping("/users/{name}/Todos")
	ResponseEntity<?> add(@PathVariable String name, @Valid @RequestBody Todo Todo) {
		Todo createdTodo = ts.addTodo(name, Todo.getDes(), Todo.getTargetDate(), Todo.isDone());
		if (createdTodo == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//update user based on id
	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable int id, @Valid @RequestBody Todo todo) {
		//  if (todo.getId() == 0) {
		//      todo.setId(id);
		//  }
		return ts.updateTodo(todo);
	}
	
	//delet user based on id
	@DeleteMapping("/{id}")
	public boolean deleteTodo(@PathVariable int id) {
		return ts.deleteTodoById(id);
	}
}