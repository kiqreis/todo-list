package br.com.kiqreis.todolistchallenge.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todos")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  private boolean realized;
  private int priority;

  public Todo(String name, String description, boolean realized, int priority) {
    this.name = name;
    this.description = description;
    this.realized = realized;
    this.priority = priority;
  }

  public Todo() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isRealized() {
    return realized;
  }

  public void setRealized(boolean realized) {
    this.realized = realized;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }
}
