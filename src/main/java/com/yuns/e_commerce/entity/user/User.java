package com.yuns.e_commerce.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false)
    private String userId; // 유저 아이디

    @Column(nullable = false)
    private String password; // 패스워드

    private String phoneNumber; // 전화번호

    @Column(nullable = false)
    private UserType userType; // 사용자 분류 타입

    private LocalDateTime registeredAt; // 회원가입 시간

    @ColumnDefault("false")
    private boolean isDeletedUser; // 회원 탈퇴 여부
}
