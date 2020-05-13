package com.cognixia.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognixia.repository.TodoRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.*;

@Service
public class TodoService {
	@Autowired
	TodoRepository tr;
	
	public Todo createTodo(Todo Todo) {
		return tr.save(Todo);
	}
	
	public List<Todo> getTodos() {
		return tr.findAll();
	}
	
	public List<Todo> getTodosByUser(String user) {
		return tr.findByUser(user);
	}
	//public Optional<Todo> getTodoById(int id) {
	//  return tr.findById(id);
	//}
}