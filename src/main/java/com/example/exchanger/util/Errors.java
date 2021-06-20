package com.example.exchanger.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Errors {

  UNABLE_TO_CONVERT("400-1", "Unable to convert, the `to` field might not be available", HttpStatus.BAD_REQUEST),
  UNABLE_TO_FETCH_TASK("400-2", "Unable to fetch task id", HttpStatus.BAD_REQUEST);
  private final String code;
  private final String description;
  private final HttpStatus httpStatus;

  @Override
  public String toString() {
    return this.code + '|' + this.description + '|' + httpStatus;
  }

}
