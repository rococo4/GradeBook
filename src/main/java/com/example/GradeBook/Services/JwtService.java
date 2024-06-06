package com.example.GradeBook.Services;

import com.example.GradeBook.store.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    private final String secret = "953dbe5e26d41751e3ba46a712a09fba687a1746941fbfd96b517bf8ee8d2884\n";
    private final Duration jwtLifeTime = Duration.ofMinutes(30);

    public String generateToken(UserEntity userEntity ) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ROLE_" + userEntity.getRole().getRoleName());
        claims.put("id", userEntity.getId());
        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + jwtLifeTime.toMillis());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userEntity.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        var t = userDetails.getUsername().equals(username);
        var a = isTokenExpired(token);
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }

    public String getRole(String token) {
        return (String) getClaimsFromToken(token).get("role");
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
