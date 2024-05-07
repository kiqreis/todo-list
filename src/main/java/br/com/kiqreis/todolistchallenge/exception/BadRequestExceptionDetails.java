package br.com.kiqreis.todolistchallenge.exception;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

@Builder
public record BadRequestExceptionDetails(String title, int status, String details,
                                         String message) implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
}
