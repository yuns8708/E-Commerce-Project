package com.yuns.e_commerce.service;

import com.yuns.e_commerce.entity.user.User;
import com.yuns.e_commerce.entity.user.UserRequestDto;
import com.yuns.e_commerce.exception.CustomException;
import com.yuns.e_commerce.exception.ErrorCode;
import com.yuns.e_commerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public ResponseEntity<?> register(UserRequestDto requestDto) {
        // 이미 존재하는 유저인지 확인
        if (userRepository.existsByUserId(requestDto.getUserId())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_MEMBER);
        }

        requestDto.setPassword(this.passwordEncoder.encode(requestDto.getPassword()));

        userRepository.save(User.builder()
                        .userId(requestDto.getUserId())
                        .password(requestDto.getPassword())
                        .phoneNumber(requestDto.getPhoneNumber())
                        .registeredAt(LocalDateTime.now())
                        .userType(requestDto.getUserType())
                .build());
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

}
