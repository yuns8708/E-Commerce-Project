package com.yuns.e_commerce.service;

import com.yuns.e_commerce.entity.user.LoginRequestDto;
import com.yuns.e_commerce.entity.user.User;
import com.yuns.e_commerce.entity.user.UserRequestDto;
import com.yuns.e_commerce.entity.user.UserResponseDto;
import com.yuns.e_commerce.exception.CustomException;
import com.yuns.e_commerce.exception.ErrorCode;
import com.yuns.e_commerce.repository.UserRepository;
import com.yuns.e_commerce.security.CustomUserDetails;
import com.yuns.e_commerce.security.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    // 회원가입
    public ResponseEntity<?> register(UserRequestDto requestDto) {
        // 이미 존재하는 회원인지 확인
        if (userRepository.existsByUserId(requestDto.getUserId())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_USER);
        }

        userRepository.save(User.builder()
                        .userId(requestDto.getUserId())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .phoneNumber(requestDto.getPhoneNumber())
                        .registeredAt(LocalDateTime.now())
                        .userType(requestDto.getUserType())
                .build());
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // 회원 탈퇴
    public ResponseEntity<?> withdraw(String userId) {
        User user = findUserByUserId(userId);

        // 이미 탈퇴한 회원인지 확인
        if (user.isDeletedUser()) {
            throw new CustomException(ErrorCode.ALREADY_DELETED_USER);
        }

        // 회원 탈퇴 여부 변경
        user.setDeletedUser(true);

        userRepository.save(user);
        return ResponseEntity.ok("회원 탈퇴가 완료되었습니다.");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUserId(username);
        return new CustomUserDetails(user);
    }

    // 로그인
    public String login(LoginRequestDto requestDto) {
        User user = findUserByUserId(requestDto.getUserId());

        // 탈퇴한 회원인지 확인
        if(user.isDeletedUser()) {
            throw new CustomException(ErrorCode.ALREADY_DELETED_USER);
        }

        // 비밀번호 일치 확인
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.PASSWORD_UNMATCH);
        }

        // 토큰 생성
        return tokenProvider.generateToken(requestDto.getUserId());
    }

    // 회원 정보 보기
    public UserResponseDto findOneUser(String userId) {
        User user = findUserByUserId(userId);
        return new UserResponseDto(user);
    }

    // userId로 회원찾기
    private User findUserByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
