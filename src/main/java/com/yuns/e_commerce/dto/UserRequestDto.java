package com.yuns.e_commerce.dto;

import com.yuns.e_commerce.type.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank(message = "아이디는 필수 입력값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/-]{5,20}$", message = "아이디는 5-20글자의 영문, 숫자, 특수문자만 사용가능합니다.")
    private String userId;

    @NotBlank(message = "패스워드는 필수 입력값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/-]{8,20}$", message = "패스워드는 8-20글자의 영문, 숫자, 특수문자만 사용가능합니다.")

    private String password;

    private String phoneNumber;

    private UserType userType;
}
