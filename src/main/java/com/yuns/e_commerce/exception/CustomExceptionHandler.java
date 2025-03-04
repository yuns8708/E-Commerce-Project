package com.yuns.e_commerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponse> handleException (CustomException e, HttpServletRequest request) {
        CustomExceptionResponse response = CustomExceptionResponse.builder()
                .errorCode(e.getErrorCode())
                .status(e.getStatus())
                .code(e.getStatus().value())
                .errorMessage(e.getErrorMessage())
                .build();
        return new ResponseEntity<>(response, e.getStatus());
    }
}
