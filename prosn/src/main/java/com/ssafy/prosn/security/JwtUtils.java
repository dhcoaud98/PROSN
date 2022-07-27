package com.ssafy.prosn.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Date;

/**
 * created by seongmin on 2022/07/27
 */
@Slf4j
@Component
@NoArgsConstructor
public class JwtUtils {
//    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

//    @Value("jwtSecret")
    private String jwtSecret = "secretasdfasdfsecretasdfasdfdqwerqwe";

    private long jwtExpirationMs = 24 * 60 * 60 * 1000L;
    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

//    public String generateJwtToken(Authentication authentication) {
//        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
//        log.info("로그 토큰 생성 시작 = {}" , authentication);
//        return Jwts.builder()
//                .setSubject((principal.getUserId()))
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith(key, SignatureAlgorithm.ES512)
//                .compact();
//    }
    public String generateJwtToken(String userId) {
//        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        log.info("로그 토큰 생성 시작 = {}" , userId);
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.ES512,jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }

    public Long getIdFromJwtToken(String token) {
        return Long.parseLong(String.valueOf(
                Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().get("id")
        ));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
