package br.com.aolindo.desafiotodolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aolindo.desafiotodolist.model.Todo;
import br.com.aolindo.desafiotodolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping
	public ResponseEntity<List<Todo>> create(@RequestBody Todo todo) {
		todoService.create(todo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<Todo>> list() {
		List<Todo> listTodo = todoService.list();
		return ResponseEntity.ok(listTodo);
	}

	@PutMapping
	public ResponseEntity<List<Todo>> update(@RequestBody Todo todo) {
		todoService.update(todo);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<Todo>> delete(@PathVariable Long id) {
		todoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
