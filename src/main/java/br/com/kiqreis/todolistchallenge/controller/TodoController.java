package br.com.kiqreis.todolistchallenge.controller;

import br.com.kiqreis.todolistchallenge.model.entity.Todo;
import br.com.kiqreis.todolistchallenge.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping
  public ResponseEntity<List<Todo>> save(@Valid @RequestBody Todo todo) {
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.save(todo));
  }

  @GetMapping
  public ResponseEntity<List<Todo>> listAll() {
    return ResponseEntity.status(HttpStatus.OK).body(todoService.listAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<List<Todo>> update(@PathVariable("id") Long id, @Valid @RequestBody Todo todo) {
    return ResponseEntity.status(HttpStatus.OK).body(todoService.update(id, todo));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<List<Todo>> delete(@PathVariable("id") Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(todoService.delete(id));
  }
}
