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
        // 이미 존재하는 회원인지 확인
        if (userRepository.existsByUserId(requestDto.getUserId())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_USER);
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

    // 회원 탈퇴
    public ResponseEntity<?> withdraw(String userId) {
        // 존재하는 회원인지 확인하고 찾기
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // 이미 탈퇴한 회원인지 확인
        if (user.isDeletedUser()) {
            throw new CustomException(ErrorCode.ALREADY_DELETED_USER);
        }

        // 회원 탈퇴 여부 변경
        user.setDeletedUser(true);

        userRepository.save(user);
        return ResponseEntity.ok("회원 탈퇴가 완료되었습니다.");
    }

}
