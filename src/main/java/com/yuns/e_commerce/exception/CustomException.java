package com.yuns.e_commerce.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomException extends RuntimeException {
    private ErrorCode errorCode;
    private HttpStatus status;
    private String errorMessage;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.status = errorCode.getStatus();
        this.errorMessage = errorCode.getDescription();
    }
}
