package com.yuns.e_commerce.dto;

import com.yuns.e_commerce.entity.User;
import com.yuns.e_commerce.type.UserType;
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
