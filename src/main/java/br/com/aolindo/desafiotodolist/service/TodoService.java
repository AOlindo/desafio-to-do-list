package br.com.aolindo.desafiotodolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.aolindo.desafiotodolist.model.Todo;
import br.com.aolindo.desafiotodolist.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
//	Existem duas formas de injetar dependencia, através da anotação @Autowired ou atraves do construtor.

//	public TodoService(TodoRepository todoRepository) {
//		this.todoRepository = todoRepository;
//	}

	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

//Lista ordenada por prioridade, depois por nome.
	public List<Todo> list() {
		return todoRepository.findAll(Sort.by("prioridade").descending().and(Sort.by("nome").ascending()));

	}

	public List<Todo> update(Todo todo) {
		todoRepository.save(todo);
		return list();

	}

	public List<Todo> delete(Long id) {
		todoRepository.deleteById(id);
		return list();

	}
}
