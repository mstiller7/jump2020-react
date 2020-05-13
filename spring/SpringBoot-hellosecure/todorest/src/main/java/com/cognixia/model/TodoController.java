package com.cognixia.model;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TodoController {
	@Autowired
	TodoService ts;
	/*
	 * @GetMapping("/Todo/{id}") Optional<Todo> getTodoByID(@PathVariable int id) {
	 * return ts.getTodoById(id); }
	 */
	@GetMapping("/Todos/{user}")
	List<Todo> getTodosByUser(@PathVariable String user) {
		return ts.getTodosByUser(user);
	}
	
	@GetMapping("/Todos")
	List<Todo> getTodos(){
		return ts.getTodos();
	}
	@PostMapping("/Todo")
	Todo createTodo(@Valid @RequestBody Todo Todo) {
		return ts.createTodo(Todo);
	}
}
