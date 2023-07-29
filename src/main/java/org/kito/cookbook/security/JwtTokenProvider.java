package org.kito.cookbook.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.kito.cookbook.entity.system.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.security.jwt.secret}")
    private String secret;

    @Value("${app.security.jwt.expiration-time}")
    private long expirationTime;

    @Value("${app.security.jwt.remember-me-expiration-time}")
    private long rememberMeExpirationTime;

    public String generateToken(String email, boolean rememberMe) {
        Date nowDate = new Date();
        Date expiryDate = new Date(nowDate.getTime() +
                (rememberMe ? this.rememberMeExpirationTime : this.expirationTime));

        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(nowDate)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }


    public String generateToken(Authentication authentication, boolean rememberMe) {
        Users users = (Users) authentication.getPrincipal();

        return generateToken(users, rememberMe);
    }

    public String generateToken(Users users, boolean rememberMe) {
        return generateToken(users.getEmail(), rememberMe);
    }

    public String generateToken(String email) {
        return generateToken(email, false);
    }

    public String generateToken(Authentication authentication) {
        return generateToken(authentication, false);
    }

    public String generateToken(Users users) {
        return generateToken(users, false);
    }

    public String getUserEmailFromJWT(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Integer getPasswordHashFromJWT(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return (Integer) claims.get("passwordHash");
    }

    public boolean validateToken(String token) throws SignatureException {
        try {
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
