package br.com.kiqreis.todolistchallenge.handler;

import br.com.kiqreis.todolistchallenge.exception.BadRequestException;
import br.com.kiqreis.todolistchallenge.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<BadRequestExceptionDetails> handleBadRequestExceptionException(BadRequestException e) {

    return new ResponseEntity<>(
            BadRequestExceptionDetails.builder()
                    .title("Bad Request")
                    .details(e.getClass().getSimpleName())
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build()
            , HttpStatus.BAD_REQUEST);
  }
}
