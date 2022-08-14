package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class MailServiceTest {
    @Autowired LocalUserRepository localUserRepository;
    @Autowired UserRepository userRepository;
    @Autowired UserService userService;

    @BeforeEach
    void before() {
        localUserRepository.save(LocalUser.builder()
                .userId("test")
                .email("duaudy@naver.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build());
    }

    @Test
    void 임시비번이메일발송() throws Exception {
        //given
        LocalUser localUser = localUserRepository.findByUserId("test").get();
        String oldPassword = localUser.getPassword();
        //when
        LocalUser changed = userService.resetPwd(localUser);
        //then
        Assertions.assertThat(oldPassword).isNotEqualTo(changed.getPassword());
    }

    @Test
    void findEmail() throws Exception {
        //given
        LocalUser localUser = localUserRepository.findByUserId("test").get();
        User user = userRepository.findById(localUser.getId()).get();

        //when
        String email = localUserRepository.findEmailByUserId(localUser.getUserId());

        //then
        System.out.println("email ====== " + email);
        Assertions.assertThat(user.getEmail()).isEqualTo(email);

    }
}