package com.yuns.e_commerce.controller;

import com.yuns.e_commerce.dto.LoginRequestDto;
import com.yuns.e_commerce.dto.UserRequestDto;
import com.yuns.e_commerce.dto.UserResponseDto;
import com.yuns.e_commerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid UserRequestDto request) {
        userService.register(request);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // 회원 탈퇴
    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<?> withdraw(@PathVariable String userId) {
        return ResponseEntity.ok("회원 탈퇴가 완료되었습니다.");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid  LoginRequestDto requestDto) {
        return ResponseEntity.ok(userService.login(requestDto));
    }

    // 회원 정보 보기
    @GetMapping("{userId}")
    public UserResponseDto findOneUser(@PathVariable String userId) {
        return userService.findOneUser(userId);
    }
}
