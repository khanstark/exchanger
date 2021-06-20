package com.example.exchanger.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ExceptionPayload {

  private HttpStatus status;
  private String message;
  private List<String> errors;

  public ExceptionPayload() {
    super();
  }

  public ExceptionPayload(final HttpStatus status, final String message, final List<String> errors) {
    super();
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public ExceptionPayload(final HttpStatus status, final String message, final String error) {
    super();
    this.status = status;
    this.message = message;
    this.errors = Collections.singletonList(error);
  }
}

