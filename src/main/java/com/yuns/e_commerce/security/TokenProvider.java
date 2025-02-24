package com.yuns.e_commerce.security;

import com.yuns.e_commerce.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenProvider {
    @Value("${spring.jwt.secret}")
    private String secretKey;

    // 토큰 생성
    public String generateToken(String userId) {
        // 만료 시간
        // 1hour
        long TOKEN_VALID = (long) 1000 * 60 * 30;
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALID))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 토큰 검증
    public boolean validateToken(String token) {
        if (!StringUtils.hasText(token)) return false;

        return !this.parseClaims(token).getExpiration().before(new Date());
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
