package br.com.kiqreis.todolistchallenge.service;

import br.com.kiqreis.todolistchallenge.exception.BadRequestException;
import br.com.kiqreis.todolistchallenge.model.entity.Todo;
import br.com.kiqreis.todolistchallenge.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Transactional(rollbackFor = Exception.class)
  public List<Todo> save(Todo todo) {
    todoRepository.save(todo);
    return listAll();
  }

  public List<Todo> listAll() {
    return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "priority")
            .and(Sort.by(Sort.Direction.ASC, "name")));

  }

  public Todo findById(Long id) {
    return todoRepository.findById(id)
            .orElseThrow(() -> new BadRequestException("Todo id not found"));
  }

  @Transactional(rollbackFor = Exception.class)
  public List<Todo> update(Long id, Todo todo) {
    Todo todoToBeUpdated = findById(id);

    todo.setId(todoToBeUpdated.getId());
    todoRepository.save(todo);

    return listAll();
  }

  public List<Todo> delete(Long id) {
    findById(id);

    todoRepository.deleteById(id);

    return listAll();
  }
}
