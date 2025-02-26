package com.estudos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
