package br.com.kiqreis.todolistchallenge.repository;

import br.com.kiqreis.todolistchallenge.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
