package com.yuns.e_commerce.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomExceptionResponse {
    private ErrorCode errorCode;
    private String errorMessage;
}
