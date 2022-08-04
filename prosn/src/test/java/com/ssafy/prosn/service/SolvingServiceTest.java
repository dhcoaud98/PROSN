package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.profiile.status.SolvingRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * created by yura on 2022/08/04
 */
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@ContextConfiguration
@Transactional
@SpringBootTest
@Rollback(false)
public class SolvingServiceTest {
    @Autowired
    private SolvingService solvingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SolvingRepository solvingRepository;
    @Autowired
    private ProblemRepository problemRepository;

    @BeforeEach
    void before() {
//        List<Tag> tagList = new ArrayList<>();
//        tagList.add(new Tag("PL", "프로그래밍 언어"));
        userRepository.save(new LocalUser("사용자1", "user@ssafy.com", "user1", "1234"));
        userRepository.save(new LocalUser("사용자2", "user2@ssafy.com", "user2", "1234"));
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));
        Problem problem1 = problemRepository.save(new Problem("자바란 무엇인가", user1, "자바", "파이썬", "C", "C++", "자바", "자바가 뭘까여"));
        Problem problem2 = problemRepository.save(new Problem("파이썬이란 무엇인가", user1, "자바", "파이썬", "C", "C++", "파이썬", "파이썬이 뭘까여"));
        Problem problem3 = problemRepository.save(new Problem("C란 무엇인가", user1, "자바", "파이썬", "C", "C++", "C", "C가 뭘까여"));
        solvingRepository.save(new Solving(user1, problem1, false));
        solvingRepository.save(new Solving(user1, problem2, true));
        solvingRepository.save(new Solving(user1, problem3, true));

//        SolvingRequestDto solvingRequestDto = SolvingRequestDto.builder()
//                .id(1L)
//                .userId(user1.getId())
//                .postId(10L)
//                .isRight(true)
//                .build();
    }

    @Test
    public void findSolving() {
//        List<User> all = userRepository.findAll();
//        List<User> all = userRepository.findAll();
//        for (User localUser : all) {
//            System.out.println("localUser = " + localUser);
//        }
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));
        List<SolvingResponseDto> solving = solvingService.showAllSolving(user.getId());
        for (SolvingResponseDto eachSolving : solving) {
            System.out.println("문제풀이현황 : " + eachSolving);
        }
//        Assertions.assertThat(3).isEqualTo(solvingRepository.findAll().size());
    }

}
