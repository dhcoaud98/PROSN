package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.TokenDto;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import com.ssafy.prosn.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * created by seongmin on 2022/07/22
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LocalUserRepository localUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder managerBuilder;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public Long join(UserJoinRequestDto joinRequestDto) {
        validateDuplicate(joinRequestDto.getUserId(), joinRequestDto.getEmail());

        Long id = userRepository.save(LocalUser.builder()
                .userId(joinRequestDto.getUserId())
                .name(joinRequestDto.getName())
                .email(joinRequestDto.getEmail())
                .password(passwordEncoder.encode(joinRequestDto.getPassword()))
                .build()).getId();
        Optional<User> byId = userRepository.findById(id);
        return byId.get().getId();
    }

    @Override
    public TokenDto login(UserLoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = loginRequestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        log.info("로그 authentication = {}", authentication);
        log.info("로그 authentication.getName = {}", authentication.getName());

        return jwtUtils.generateJwtToken(authentication);
    }

    private void validateDuplicate(String userId, String email) {
        if (localUserRepository.existsByUserId(userId)) {
            throw new IllegalStateException("이미 있는 아이디입니다.");
        }
        if (localUserRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 있는 이메일입니다.");
        }
    }
}
