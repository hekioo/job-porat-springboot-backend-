package com.boot.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    private String SECRET_KEY = "u8Jd9sK3lP5q8X2rT6v9yB1nC4e7gH0jM2p5sV8xZ1a4dF7kQ3w6tY9zL2o5rU8";
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);

    }

    private String createToken(Map<String, Object> claims,String username) {

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .header().empty().add("typ", "jwt")
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000*60*5))
                .signWith(getSigningKey())
                .compact();

    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }


    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

}
