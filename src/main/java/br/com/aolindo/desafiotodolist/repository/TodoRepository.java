package br.com.aolindo.desafiotodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aolindo.desafiotodolist.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
