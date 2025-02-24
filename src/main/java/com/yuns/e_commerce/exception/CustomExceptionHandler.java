package com.yuns.e_commerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CustomExceptionResponse handleException (CustomException e, HttpServletRequest request) {
        return CustomExceptionResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getErrorMessage())
                .build();
    }
}
