package com.estudos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	// FINDALL
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> findAll() {
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}

}
