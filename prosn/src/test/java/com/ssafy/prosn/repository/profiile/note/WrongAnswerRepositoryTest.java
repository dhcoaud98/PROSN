package com.ssafy.prosn.repository.profiile.note;

import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.NoteDto;
import com.ssafy.prosn.dto.ProblemRequestDto;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import com.ssafy.prosn.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/08/06
 */
@Transactional
@SpringBootTest
class WrongAnswerRepositoryTest {

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WrongAnswerRepository wrongAnswerRepository;

    @BeforeEach
    void before() {
        User user = LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build();
        userRepository.save(user);

        postService.writeProblem(ProblemRequestDto.builder()
                .title("HTTP에 대해서")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .build(), user.getId());

        postService.writeProblem(ProblemRequestDto.builder()
                .title("2번문제")
                .mainText("22222222")
                .ex1("1")
                .ex2("2")
                .ex3("3")
                .ex4("4")
                .answer("3")
                .tags(List.of("NW", "AL", "OS"))
                .build(), user.getId());

        postService.writeProblem(ProblemRequestDto.builder()
                .title("333333")
                .mainText("3번문제")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("CS", "AL", "DS"))
                .build(), user.getId());

        postService.writeProblem(ProblemRequestDto.builder()
                .title("44444")
                .mainText("4번문제")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("ETC"))
                .build(), user.getId());

        postService.writeProblem(ProblemRequestDto.builder()
                .title("55555")
                .mainText("5번문제")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW", "OS"))
                .build(), user.getId());

        List<Problem> problems = problemRepository.findAll();
        wrongAnswerRepository.save(WrongAnswer.builder()
                .problem(problems.get(0))
                .user(user)
                .wrong_answer("GET")
                .build());
        wrongAnswerRepository.save(WrongAnswer.builder()
                .problem(problems.get(1))
                .user(user)
                .wrong_answer("2")
                .build());
        wrongAnswerRepository.save(WrongAnswer.builder()
                .problem(problems.get(2))
                .user(user)
                .wrong_answer("GET")
                .build());
        wrongAnswerRepository.save(WrongAnswer.builder()
                .problem(problems.get(3))
                .user(user)
                .wrong_answer("GET")
                .build());

        WrongAnswer wr4 = WrongAnswer.builder()
                .problem(problems.get(4))
                .user(user)
                .wrong_answer("GET")
                .build();
        wrongAnswerRepository.save(wr4);
        wr4.write();

    }

    @Test
    @DisplayName("오답노트 목록 조회")
    @Commit
    void getNotes() {
        // given
        User user = userRepository.findById(1L).get();

        // when
        Page<NoteDto> result1 = wrongAnswerRepository.findWrongAnswer(user, false, PageRequest.of(0, 3), "NW");
        Page<NoteDto> result2 = wrongAnswerRepository.findWrongAnswer(user, false, PageRequest.of(0, 3), "AL");

        for (NoteDto noteDto : result1) {
            List<PostTag> postTags = noteDto.getProblem().getPostTags();
            String title = noteDto.getTitle();
            System.out.println("title = " + title);
            for (PostTag postTag : postTags) {
                System.out.println("postTag = " + postTag.getTag());
            }
        }
        // then
        assertThat(result1.getNumberOfElements()).isEqualTo(2);
        assertThat(result2.getNumberOfElements()).isEqualTo(2);
    }
}