package org.musinsa.application.exception.base;

import javax.validation.ConstraintViolation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ErrorBox {

  private String causeValue;

  private String message;

  public static ErrorBox create(ConstraintViolation<?> constraintViolation) {
    String builder = "["
        + constraintViolation.getPropertyPath().toString()
        + "](은)는 "
        + constraintViolation.getMessage();
    return new ErrorBox(
        constraintViolation.getInvalidValue().toString(),
        builder
    );
  }

  public static ErrorBox create(FieldError fieldError) {
    String builder = "["
        + fieldError.getField()
        + "](은)는 "
        + fieldError.getDefaultMessage();

    return new ErrorBox(
        fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString()
            : "",
        builder
    );
  }

  public static ErrorBox create(String causeValue, String message) {
    return new ErrorBox(
        causeValue,
        message
    );
  }
}
