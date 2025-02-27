package com.estudos.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.domain.Todo;
import com.estudos.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring 2 com Angular",
				LocalDateTime.parse("24/03/2025 20:28", formatter), false);
		
		Todo t2 = new Todo(null, "Correr", "Meia Maratona do Rio",
				LocalDateTime.parse("30/03/2025 20:28", formatter), true);
		
		Todo t3 = new Todo(null, "Estudar", "JavaScript",
				LocalDateTime.parse("27/02/2025 20:28", formatter), false);
		
		Todo t4 = new Todo(null, "Estudar", "Para Concurso",
				LocalDateTime.parse("24/01/2025 20:28", formatter), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
