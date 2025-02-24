package com.yuns.e_commerce.entity.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String userId;
    private String phoneNumber;
    private UserType userType;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.phoneNumber = user.getPhoneNumber();
        this.userType = user.getUserType();
    }
}
