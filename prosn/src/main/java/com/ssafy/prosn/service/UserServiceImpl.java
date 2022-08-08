package com.ssafy.prosn.service;

import com.ssafy.prosn.config.SecurityUtil;
import com.ssafy.prosn.domain.profile.scrap.PostList;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.TokenDto;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.repository.profiile.scrap.PostListRepository;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import com.ssafy.prosn.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by seongmin on 2022/07/22
 * updated by yeomyeong on 2022/08/07 (resetPwd)
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
    private final PostListRepository postListRepository;
    private final MailService mailService;

    @Override
    @Transactional
    public Long join(UserJoinRequestDto joinRequestDto) {
        validateDuplicate(joinRequestDto.getUserId(), joinRequestDto.getEmail());

        LocalUser user = userRepository.save(LocalUser.builder()
                .userId(joinRequestDto.getUserId())
                .name(joinRequestDto.getName())
                .email(joinRequestDto.getEmail())
                .password(passwordEncoder.encode(joinRequestDto.getPassword()))
                .build());

        // 회원가입 시 스크랩 기본 폴더 생성
        postListRepository.save(PostList.builder()
                .user(user)
                .title("기본 폴더")
                .build());
        return user.getId();
    }

    @Override
    public TokenDto login(UserLoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = loginRequestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        log.info("authentication = {}", authentication);
        log.info("authentication.getName = {}", authentication.getName());
        TokenDto tokenDto = jwtUtils.generateJwtToken(authentication);
        LocalUser loginUser = localUserRepository.findByUserId(loginRequestDto.getUserId()).get();
        tokenDto.setIdAndName(loginUser.getId(), loginUser.getName());

        return tokenDto;
    }

    @Override
    public UserResponseDto getMyInfoBySecret() {
        return userRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(UserResponseDto::of)
                .orElseThrow(() -> new UsernameNotFoundException("로그인 유저 정보가 없습니다."));
    }

    private void validateDuplicate(String userId, String email) {
        if (localUserRepository.existsByUserId(userId)) {
            throw new IllegalStateException("이미 있는 아이디입니다.");
        }
        if (localUserRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 있는 이메일입니다.");
        }
    }

    @Transactional
    public LocalUser resetPwd(LocalUser user) {
        String encodedResetPassword = mailService.sendMail(user.getEmail());
        return user.updatePassword(encodedResetPassword);
    }

}
