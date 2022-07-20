package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/20
 */
@Transactional
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {

        User user = LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@")
                .name("테스터")
                .build();
        Post post = Problem.builder()
                .user(user)
                .title("HTTP 기본")
                .mainText("다음 중 HTTP 메서드가 아닌 것을 고르시오.")
                .example1("UPDATE")
                .example2("GET")
                .example3("POST")
                .example4("DELETE")
                .answer("UPDATE")
                .build();

        User saveUser = userRepository.save(user);
        Post savePost = postRepository.save(post);

        Post findPost = postRepository.findById(post.getId()).get();
        User findUser = userRepository.findById(user.getId()).get();
        assertThat(findPost).isEqualTo(savePost);
        assertThat(findUser.getPoint()).isEqualTo(0);

    }
}