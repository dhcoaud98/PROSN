package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/22
 */
@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private LocalUserRepository localUserRepository;

    @BeforeEach
    void before() {
        localUserRepository.save(LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build());
    }

    @Test
    void join() {
        UserJoinRequestDto successUser = new UserJoinRequestDto("prosn@gmail.com", "prosn", "qwert1234@QQ", "프로즌");
        Long id = userService.join(successUser);
        assertThat(id).isEqualTo(2L);

        UserJoinRequestDto duplicateEmail = new UserJoinRequestDto("test@gmail.com", "prosn22", "qwert1234@QQ", "프로즌");
        assertThatThrownBy(() -> userService.join(duplicateEmail))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이메일");

        UserJoinRequestDto duplicateId = new UserJoinRequestDto("prosn2@gmail.com", "test", "qwert1234@QQ", "프로즌");
        assertThatThrownBy(() -> userService.join(duplicateId))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("아이디");


    }
}