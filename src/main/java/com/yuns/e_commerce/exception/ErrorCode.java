package com.yuns.e_commerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST_MEMBER("이미 존재하는 사용자입니다.");
    private final String description;
}
