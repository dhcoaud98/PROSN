package com.ssafy.prosn.config;

import com.ssafy.prosn.security.AuthTokenFilter;
import com.ssafy.prosn.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtUtils jwtUtils;

    @Override
    public void configure(HttpSecurity http) {
        AuthTokenFilter customFilter = new AuthTokenFilter(jwtUtils);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
