package br.com.kiqreis.todolistchallenge;

import br.com.kiqreis.todolistchallenge.model.entity.Todo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistChallengeApplicationTests {

  @Autowired
  private WebTestClient webTestClient;

  static private Todo todo;

  @BeforeAll
  static void setUp() {
    todo = new Todo("todo 1", "description todo", false, 1);
  }

  @Test
  void createTodoWhenSuccessfully() {

    webTestClient
            .post()
            .uri("/todos")
            .bodyValue(todo)
            .exchange()
            .expectStatus().isCreated()
            .expectBody()
            .jsonPath("$").isArray()
            .jsonPath("$.length()").isEqualTo(1)
            .jsonPath("$[0].id").isEqualTo(1)
            .jsonPath("$[0].name").isEqualTo(todo.getName())
            .jsonPath("$[0].description").isEqualTo(todo.getDescription())
            .jsonPath("$[0].realized").isEqualTo(todo.isRealized())
            .jsonPath("$[0].priority").isEqualTo(todo.getPriority());
  }

  @Test
  void createTodoWhenFailure() {
    webTestClient
            .post()
            .uri("/todos")
            .bodyValue(new Todo("", "", false, 0))
            .exchange()
            .expectStatus().isBadRequest();
  }

  @Test
  void updateTodoWhenSuccessfully() {

    todo.setName("todo 1 updated");
    todo.setDescription("description todo updated");
    todo.setPriority(1);
    todo.setRealized(true);

    webTestClient
            .put()
            .uri("/todos/{id}", 1)
            .bodyValue(todo)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$[0].name").isEqualTo("todo 1 updated")
            .jsonPath("$[0].description").isEqualTo("description todo updated")
            .jsonPath("$[0].priority").isEqualTo(1)
            .jsonPath("$[0].realized").isEqualTo(true);
  }

  @Test
  void updateTodoWhenFailure() {

    webTestClient
            .put()
            .uri("/todos/{id}", 1)
            .bodyValue(new Todo("", "", false, 0))
            .exchange()
            .expectStatus().isBadRequest();
  }

  @Test
  void deleteTodoWhenSuccessfully() {

    webTestClient
            .delete()
            .uri("/todos/{id}", 1)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$").isArray()
            .jsonPath("$.length()").isEqualTo(0);
  }

}
