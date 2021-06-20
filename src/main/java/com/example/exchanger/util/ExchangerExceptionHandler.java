package com.example.exchanger.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExchangerExceptionHandler extends ResponseEntityExceptionHandler {

  // this function can be overloaded with different parameter types, using same
  // ExchangerException.class
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionPayload> handleFlowableObjectNotFoundException(Exception ex,
                                                                                      WebRequest request) {
    logTheException(ex);
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ExceptionPayload exceptionPayload = new ExceptionPayload(HttpStatus.BAD_REQUEST,
        "Could not complete the request", details);
    return new ResponseEntity<>(exceptionPayload, new HttpHeaders(), exceptionPayload.getStatus());
  }

  @ExceptionHandler(ExchangerException.class)
  public final ResponseEntity<ExceptionPayload> handleExchangerException(ExchangerException ex, WebRequest request) {
    logTheException(ex);
    ExceptionPayload exceptionPayload = new ExceptionPayload(ex.getError().getHttpStatus(), ex.getMessage(),
        ex.getMessage());
    return new ResponseEntity<>(exceptionPayload, new HttpHeaders(), exceptionPayload.getStatus());
  }

  private void logTheException(Throwable ex) {
    log.error("error occured", ex);
  }

}
