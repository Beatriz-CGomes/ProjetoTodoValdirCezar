package com.estudos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public void instanciaBaseDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring 2 com Angular", sdf.parse("25/03/2025"), false);

		Todo t2 = new Todo(null, "Correr", "Meia Maratona do Rio", sdf.parse("30/03/2025"), true);

		Todo t3 = new Todo(null, "Estudar", "JavaScript", sdf.parse("27/02/2025"), false);

		Todo t4 = new Todo(null, "Estudar", "Para Concurso", sdf.parse("24/01/2025"), true);

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
