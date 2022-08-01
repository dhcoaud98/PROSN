package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.profiile.note.WrongAnswerRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created by seongmin on 2022/07/29
 * updated by seongmin on 2022/08/01
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class WrongAnswerServiceImpl implements WrongAnswerService {

    private final WrongAnswerRepository wrongAnswerRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ProblemRepository problemRepository;
    private final PostTagRepository postTagRepository;

    // 틀린 문제 저장
    @Override
    @Transactional
    public WrongAnswer save(WrongAnswerRequestDto dto) {
        User user = getUser();
        Optional<Problem> problem = problemRepository.findById(dto.getPid());
        problem.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 문제입니다."));
        // 문제집에서 풀었는데 삭제된 문제라면 어떻게??

        // 이미 오답문제에 있는 문제라면? 틀린답만 수정 or 수정x
        boolean check = wrongAnswerRepository.existsByUserAndProblem(user, problem.get());
        if (check) {
            throw new IllegalStateException("이미 오답노트에 있는 문제입니다.");
        }

        WrongAnswer wrongAnswer = WrongAnswer.builder()
                .problem(problem.get())
                .user(user)
                .wrong_answer(dto.getWrongAnswer())
                .build();
        return wrongAnswerRepository.save(wrongAnswer);
    }

    // 오답 노트 수정
    @Override
    @Transactional
    public void write(WrongNoteRequestDto dto) {
        WrongAnswer wrongAnswer = validWrongAnswer(dto.getId());
        User user = getUser();

        if (!user.getId().equals(wrongAnswer.getUser().getId())) {
            throw new IllegalStateException("권한이 없습니다."); // 403으로 리턴하도록하기.
        }

        wrongAnswer.writeMemo(dto.getMemo());
        wrongAnswer.writeReason(dto.getReason());
        wrongAnswer.writeStudyContent(dto.getStudyContent());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        WrongAnswer wrongAnswer = validWrongAnswer(id);
        User user = getUser();

        if (!user.getId().equals(wrongAnswer.getUser().getId())) {
            throw new IllegalStateException("권한이 없습니다."); // 403으로 리턴하도록하기.
        }

        wrongAnswerRepository.delete(wrongAnswer);
    }

    // 내 오답노트 전체(목록) 조회
    @Override
    public List<NoteResponseDto> getNote() {
        User user = getUser();
        List<WrongAnswer> notes = wrongAnswerRepository.findByUser(user);
        List<NoteResponseDto> result = new ArrayList<>();
        for (WrongAnswer note : notes) {
            NoteResponseDto.builder()
                    .id(note.getId())
                    .isWrite(note.isWrite())
                    .title(note.getProblem().getTitle())
                    .build();
        }
        return result;
    }

    // 오답노트에서 특정 문제 디테일 조회
    @Override
    public WrongAnswerNoteDetailResponseDto getNoteDetail(Long id) {
        WrongAnswer wrongAnswer = validWrongAnswer(id);
        List<PostTag> postTagByPost = postTagRepository.findPostTagByPost(wrongAnswer.getProblem());
        List<Tag> tags = new ArrayList<>();
        for (PostTag postTag : postTagByPost) {
            tags.add(postTag.getTag());
        }
        return WrongAnswerNoteDetailResponseDto.builder()
                .id(id)
                .pid(wrongAnswer.getProblem().getId())
                .pid(wrongAnswer.getProblem().getId())
                .title(wrongAnswer.getProblem().getTitle())
                .tags(tags)
                .mainText(wrongAnswer.getProblem().getMainText())
                .example1(wrongAnswer.getProblem().getExample1())
                .example2(wrongAnswer.getProblem().getExample2())
                .example3(wrongAnswer.getProblem().getExample3())
                .example4(wrongAnswer.getProblem().getExample4())
                .answer(wrongAnswer.getProblem().getAnswer())
                .wrongAnswer(wrongAnswer.getWrongAnswer())
                .reason(wrongAnswer.getReason())
                .studyContent(wrongAnswer.getStudyContent())
                .memo(wrongAnswer.getMemo())
                .isWrite(wrongAnswer.isWrite())
                .build();
    }

    private WrongAnswer validWrongAnswer(Long id) {
        Optional<WrongAnswer> wrongAnswer = wrongAnswerRepository.findById(id);
        wrongAnswer.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 오답노트입니다."));
        return wrongAnswer.get();
    }

    private User getUser() {
        UserResponseDto myInfo = userService.getMyInfoBySecret();
        Optional<User> user = userRepository.findById(myInfo.getId());
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        return user.get();
    }

}
