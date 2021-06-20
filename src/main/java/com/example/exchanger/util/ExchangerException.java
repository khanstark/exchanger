package com.example.exchanger.util;

import lombok.Getter;

@Getter
public class ExchangerException extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 5385445848495223932L;

  private final Errors error;

  private final String message;

  public ExchangerException(Errors error) {
    super(error.toString());
    this.error = error;
    this.message = error.toString();
  }

  public ExchangerException(Errors error, Throwable failureReason) {
    super(error.toString(), failureReason);
    this.error = error;
    this.message = error.toString();
  }

  public ExchangerException(Errors error, String message) {
    super(message);
    this.error = error;
    this.message = message;
  }

  public ExchangerException(Errors error, String message, Throwable throwable) {
    super(message,throwable);
    this.error = error;
    this.message = message;
  }
}
