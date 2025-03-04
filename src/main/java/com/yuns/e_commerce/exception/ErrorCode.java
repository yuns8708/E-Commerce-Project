package com.yuns.e_commerce.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 회원입니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 회원입니다."),
    ALREADY_DELETED_USER(HttpStatus.BAD_REQUEST,"이미 탈퇴한 회원입니다."),
    PASSWORD_UNMATCH(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다."),
    USER_UN_MATCH(HttpStatus.BAD_REQUEST, "회원 정보가 일치하지 않습니다.");
    private final HttpStatus status;
    private final String description;
}
