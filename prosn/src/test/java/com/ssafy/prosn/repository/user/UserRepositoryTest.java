package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/20
 */
@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalUserRepository localUserRepository;

    @BeforeEach
    void before() {
        User user1 = LocalUser.builder()
                .userId("test1")
                .email("test1@gmail.com")
                .password("qwert1234@")
                .name("테스터1")
                .build();
        User user2 = LocalUser.builder()
                .userId("test2")
                .email("test2@gmail.com")
                .password("qwert1234@")
                .name("테스터2")
                .build();
        User user3 = LocalUser.builder()
                .userId("test3")
                .email("test3@gmail.com")
                .password("qwert1234@")
                .name("테스터3")
                .build();
        user1.earnPoints(10);
        user2.earnPoints(15);
        user3.earnPoints(5);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }

    @Test
    @DisplayName("user를 저장한다.")
    void save() {
        User user = LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@")
                .name("테스터")
                .build();

        User saveUser = userRepository.save(user);
        User findUser = userRepository.findById(user.getId()).get();

        assertThat(findUser).isEqualTo(user);
    }

    @Test
    @DisplayName("전체 user를 조회한다.")
    void findAll() {
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("user를 point가 많은 순으로 조회한다.")
    void findTop3Point() {
        List<User> result = userRepository.findRanking();
        assertThat(result.get(0).getPoint()).isEqualTo(15);
    }

    @Test
    @DisplayName("email 중복 확인")
    void duplicateEmail() {
        User joinUser = LocalUser.builder()
                .userId("test10")
                .email("test1@gmail.com")
                .password("qwert1234@")
                .name("테스터")
                .build();

        User joinUser2 = LocalUser.builder()
                .userId("test10")
                .email("test2020@gmail.com")
                .password("qwert1234@")
                .name("테스터")
                .build();

        boolean result1 = localUserRepository.existsByEmail(joinUser.getEmail());
        assertThat(result1).isTrue();

        boolean result2 = localUserRepository.existsByEmail(joinUser2.getEmail());
        assertThat(result2).isFalse();
    }

    @Test
    @DisplayName("랭킹 top 5")
    void ranking() {
        User user1 = LocalUser.builder()
                .userId("test4")
                .email("test4@gmail.com")
                .password("qwert1234@")
                .name("테스터4")
                .build();
        user1.earnPoints(100);
        userRepository.save(user1);

        User user2 = LocalUser.builder()
                .userId("test5")
                .email("test5@gmail.com")
                .password("qwert1234@")
                .name("테스터5")
                .build();
        user2.earnPoints(100);
        userRepository.save(user2);

        User user3 = LocalUser.builder()
                .userId("test6")
                .email("test6@gmail.com")
                .password("qwert1234@")
                .name("테스터6")
                .build();
        user3.earnPoints(40);
        userRepository.save(user3);

        List<User> top5ByPointDesc = userRepository.findTop5ByOrderByPointDesc();
        assertThat(top5ByPointDesc.size()).isEqualTo(5);
        assertThat(top5ByPointDesc.get(0).getPoint()).isEqualTo(100);
    }
}