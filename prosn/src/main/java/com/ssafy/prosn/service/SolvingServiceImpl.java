package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.SolvingRequestDto;
import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.profiile.status.SolvingRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SolvingServiceImpl implements SolvingService {
    private final SolvingRepository solvingRepository;
    private final PostTagRepository postTagRepository;
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final int POINT = 10;

    @Override
    public List<SolvingResponseDto> showAllSolving(Long userId) {
        List<Solving> solvings = solvingRepository.findSolvingByUserId(userId);
        List<SolvingResponseDto> result = new ArrayList<>();

        for (Solving solving : solvings) {
            List<PostTag> postTagByPost = postTagRepository.findPostTagByPost(solving.getProblem());
            List<Tag> tags = new ArrayList<>();
            for (PostTag postTag : postTagByPost) {
                tags.add(postTag.getTag());
            }

            result.add(SolvingResponseDto.builder()
                    .postId(solving.getId())
                    .tagCode(tags)
                    .title(solving.getProblem().getTitle())
                    .isRight(solving.isRight())
                    .build());
        }
        return result;
    }

    @Override
    @Transactional
    public void problemSolving(Long uid, SolvingRequestDto dto) {
        User user = userRepository.findById(uid).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Problem problem = problemRepository.findById(dto.getPid()).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 문제입니다."));
        Optional<Solving> checkSolving = solvingRepository.findByUserAndProblem(user, problem);
        if (checkSolving.isPresent()) {
            if (!checkSolving.get().isRight() && dto.isRight()) { // 다시풀어서 맞음
                checkSolving.get().correctAnswer();
                user.earnPoints(POINT);
            }
        } else {
            Solving solving = Solving.builder()
                    .user(user)
                    .problem(problem)
                    .isRight(dto.isRight())
                    .build();
            solvingRepository.save(solving);
            if (dto.isRight()) {
                user.earnPoints(POINT);
            }
        }


    }
}
