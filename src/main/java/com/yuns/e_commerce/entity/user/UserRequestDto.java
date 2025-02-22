package com.yuns.e_commerce.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String userId;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
