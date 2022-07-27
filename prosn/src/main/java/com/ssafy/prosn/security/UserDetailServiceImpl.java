package com.ssafy.prosn.security;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * created by seongmin on 2022/07/27
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {


    private final LocalUserRepository localUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("로그 UserDetailServiceImpl 시작");
        
        LocalUser user = localUserRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("찾을 수 없는 아이디 : " + userId));
        log.info("로그 UserDetailServiceImpl 끝");
        return UserDetailsImpl.build(user);
    }
}
