package com.estudos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.domain.Todo;
import com.estudos.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService service;

	// FINDBYID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo objOptional = service.findById(id);
		return ResponseEntity.ok().body(objOptional);
	}

	// FINDALLOPEN
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> findAllOpen() {
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

	// FINDALLCLOSE
	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> findAllClose() {
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}

	// FINALL
	@GetMapping
	public ResponseEntity<List<Todo>> findAll() {
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
