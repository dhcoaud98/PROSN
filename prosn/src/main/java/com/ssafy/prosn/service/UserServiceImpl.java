package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Long join(UserJoinRequestDto joinRequestDto) {
        validateDuplicate(joinRequestDto.getUserId(), joinRequestDto.getEmail());

        return userRepository.save(LocalUser.builder()
                .userId(joinRequestDto.getUserId())
                .name(joinRequestDto.getName())
                .email(joinRequestDto.getEmail())
                .password(passwordEncoder.encode(joinRequestDto.getPassword()))
                .build()).getId();
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
