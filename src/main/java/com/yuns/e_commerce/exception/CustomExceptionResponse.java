package com.yuns.e_commerce.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomExceptionResponse {
    private ErrorCode errorCode;
    private HttpStatus status;
    private int code;
    private String errorMessage;
}
