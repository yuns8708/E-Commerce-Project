package com.yuns.e_commerce.entity.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String userId;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
