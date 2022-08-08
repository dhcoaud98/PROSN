package com.ssafy.prosn.repository.profile;

import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.profiile.status.SolvingRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class SolvingRepositoryTest {
    @Autowired
    private SolvingRepository solvingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProblemRepository problemRepository;

    @Test
    void findSolving() {
        User user = LocalUser.builder()
                .userId("solvingTest")
                .email("solvingTest@gmail.com")
                .password("solving1@")
                .name("문제풀이현황테스터")
                .build();

        userRepository.save(user);

        Problem problem = Problem.builder()
                .title("문제풀이테스트")
                .user(user)
                .example1("e1")
                .example2("e1")
                .example3("e1")
                .example4("e1")
                .answer("e1")
                .mainText("문제풀이현황 테스트입니다.")
                .build();

        problemRepository.save(problem);

        solvingRepository.save(new Solving(user, problem, true));
    }
}
