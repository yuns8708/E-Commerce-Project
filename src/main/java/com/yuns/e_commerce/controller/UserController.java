package com.yuns.e_commerce.controller;

import com.yuns.e_commerce.entity.user.LoginRequestDto;
import com.yuns.e_commerce.entity.user.UserRequestDto;
import com.yuns.e_commerce.security.TokenProvider;
import com.yuns.e_commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenProvider tokenProvider;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(userService.register(request));
    }

    // 회원 탈퇴
    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<?> withdraw(@PathVariable String userId) {
        return ResponseEntity.ok(userService.withdraw(userId));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto) {
        return ResponseEntity.ok(userService.login(requestDto));
    }
}
