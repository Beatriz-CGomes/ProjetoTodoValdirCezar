package com.estudos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.domain.Todo;
import com.estudos.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	// FINDBYID
	public Todo findById(Integer id) {
		Optional<Todo> objOptional = repository.findById(id);
		return objOptional.orElse(null);
	}

	// FINDALL
	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}
}
