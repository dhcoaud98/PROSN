package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.profiile.note.WrongAnswerRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/08/01
 */
@SpringBootTest
@Transactional
@Slf4j
class WrongAnswerServiceImplTest {

    @Autowired
    private WrongAnswerService wrongAnswerService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;
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

        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("HTTP에 대해서")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .build();

        Post post = postService.writeProblem(problemDto, user.getId());
    }

    @Test
    @DisplayName("오답노트에 저장")
    void save() {
        // given
        Post post = postRepository.findAll().get(0);
        User user = userRepository.findAll().get(0);
        WrongAnswerRequestDto dto = new WrongAnswerRequestDto(post.getId(), "OPTION");

        // when
        WrongAnswer wrongAnswer = wrongAnswerService.save(dto, user.getId());

        // then
        assertThat(wrongAnswerRepository.findAll().size()).isEqualTo(1);
        assertThat(wrongAnswerRepository.findAll().get(0).getId()).isEqualTo(wrongAnswer.getId());
    }

    @Test
    @DisplayName("오답노트 작성(수정)")
    void write() {
        // given
        Post post = postRepository.findAll().get(0);
        User user = userRepository.findAll().get(0);
        WrongAnswerRequestDto wrongAnswerDto = new WrongAnswerRequestDto(post.getId(), "OPTION");
        WrongAnswer wrongAnswer = wrongAnswerService.save(wrongAnswerDto, user.getId());
        WrongNoteRequestDto wrongNoteDto = new WrongNoteRequestDto(wrongAnswer.getId(), "헷갈렸다", "OPTION도 HTTP 메서드이다.", "이제 안틀린다.");

        // when
        wrongAnswerService.write(wrongNoteDto, user.getId());

        // then
        assertThat(wrongAnswerRepository.findById(wrongAnswer.getId()).get().getReason()).isEqualTo("헷갈렸다");
    }

    @Test
    @DisplayName("오답노트 삭제")
    void delete() {
        // given
        Post post = postRepository.findAll().get(0);
        User user = userRepository.findAll().get(0);
        WrongAnswerRequestDto dto = new WrongAnswerRequestDto(post.getId(), "OPTION");
        WrongAnswer wrongAnswer = wrongAnswerService.save(dto, user.getId());

        assertThat(wrongAnswerRepository.findAll().size()).isEqualTo(1);

        // when
        wrongAnswerService.delete(wrongAnswer.getId(), user.getId());

        // then
        assertThat(wrongAnswerRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("내 오답노트 전체(목록) 조회")
    void getNote() {
        // given
        LocalUser user2 = LocalUser.builder()
                .userId("test2")
                .email("test2@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌2")
                .build();
        userRepository.save(user2);
        LocalUser user3 = LocalUser.builder()
                .userId("test3")
                .email("test3@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌3")
                .build();
        userRepository.save(user3);

        User user = userRepository.findAll().get(0);
        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("답을 맞춰봐")
                .mainText("답이뭘까?")
                .ex1("이거")
                .ex2("요거")
                .ex3("설마요거?")
                .ex4("이건가")
                .answer("요거")
                .tags(List.of("ETC"))
                .build();

        postService.writeProblem(problemDto, user.getId());
        Post post1 = postRepository.findAll().get(0);
        Post post2 = postRepository.findAll().get(1);

        WrongAnswer wrongAnswer1 = wrongAnswerService.save(new WrongAnswerRequestDto(post1.getId(), "OPTION"), user.getId());
        WrongAnswer wrongAnswer2 = wrongAnswerService.save(new WrongAnswerRequestDto(post2.getId(), "요거"), user.getId());

        // when
        wrongAnswerService.write(new WrongNoteRequestDto(wrongAnswer1.getId(), "헷갈렸다", "OPTION도 HTTP 메서드이다.", "이제 안틀린다."), user.getId());
        wrongAnswerService.write(new WrongNoteRequestDto(wrongAnswer2.getId(), "zzz", "잘찍자", "다음엔 운 좋겠지"), user.getId());

        NoteResponseDto note = wrongAnswerService.getNote(user.getId(), PageRequest.of(0,3), false);

        // then
        assertThat(note.getContent().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("오답노트 디테일 조회")
    void getNoteDetail() {
        // given
        Post post = postRepository.findAll().get(0);
        User user = userRepository.findAll().get(0);
        WrongAnswerRequestDto wrongAnswerDto = new WrongAnswerRequestDto(post.getId(), "OPTION");
        WrongAnswer wrongAnswer = wrongAnswerService.save(wrongAnswerDto, user.getId());
        WrongNoteRequestDto wrongNoteDto = new WrongNoteRequestDto(wrongAnswer.getId(), "헷갈렸다", "OPTION도 HTTP 메서드이다.", "이제 안틀린다.");
        wrongAnswerService.write(wrongNoteDto, user.getId());

        // when
        WrongAnswerNoteDetailResponseDto noteDetail = wrongAnswerService.getNoteDetail(wrongAnswer.getId(), user.getId());

        // then
        log.info("noteDetail = {}" , noteDetail);
        assertThat(noteDetail.getPid()).isEqualTo(post.getId());
    }
}