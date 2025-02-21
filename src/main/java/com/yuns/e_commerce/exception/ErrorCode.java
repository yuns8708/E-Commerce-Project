package com.yuns.e_commerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST_USER("이미 존재하는 회원입니다."),
    USER_NOT_FOUND("존재하지 않는 회원입니다."),
    ALREADY_DELETED_USER("이미 탈퇴한 회원입니다.");
    private final String description;
}
