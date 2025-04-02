package com.estudos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudos.domain.Todo;
import com.estudos.services.TodoService;

@CrossOrigin("*")
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

	// POST
	@PostMapping
	public ResponseEntity<Todo> post(@RequestBody Todo todo) {
		todo = service.post(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(todo.getId()).toUri();
		return ResponseEntity.created(uri).body(todo);
	}

	// DELETE
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> put(@PathVariable Integer id, @RequestBody Todo todo) {
		Todo todoNew = service.put(id, todo);
		return ResponseEntity.ok().body(todoNew);
	}

}
