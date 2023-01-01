package org.musinsa.application.exception.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationBaseRunTimeException.class)
    protected ResponseEntity<ErrorResponse> handleStandardException(
        ApplicationBaseRunTimeException e) {

        ApplicationErrorCode customErrorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.create(e);
        return new ResponseEntity<>(response, customErrorCode.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> mMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        ApplicationErrorCode customErrorCode = ApplicationErrorCode.VALID_EXCEPTION;
        final ErrorResponse response = ErrorResponse.create(e);
        return new ResponseEntity<>(response, customErrorCode.getHttpStatus());
    }
}
