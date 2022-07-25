package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Information;
import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.ProblemRequestDto;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.post.tag.TagRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * created by seongmin on 2022/07/22
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostTagRepository postTagRepository;
    private final TagRepository tagRepository;
    @Override
    public Long writeProblem(ProblemRequestDto problemDto) {
        Optional<User> user = userRepository.findById(problemDto.getUid());
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Problem problem = Problem.builder()
                .user(user.get())
                .title(problemDto.getTitle())
                .answer(problemDto.getAnswer())
                .example1(problemDto.getEx1())
                .example2(problemDto.getEx2())
                .example3(problemDto.getEx3())
                .example4(problemDto.getEx4())
                .mainText(problemDto.getMainText())
                .build();
        postRepository.save(problem);
        problemDto.getTags().forEach(code -> {
            Optional<Tag> tag = tagRepository.findByCode(code);
            tag.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 태그입니다."));
            postTagRepository.save(new PostTag(problem, tag.get()));
        });
        return problem.getId();
    }

    @Override
    public Long writeInformation(InformationRequestDto informationDto) {
        Optional<User> user = userRepository.findById(informationDto.getUid());
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Information information = Information.builder()
                .user(user.get())
                .mainText(informationDto.getMainText())
                .title(informationDto.getTitle())
                .build();
        postRepository.save(information);
        informationDto.getTags().forEach(code -> {
            Optional<Tag> tag = tagRepository.findByCode(code);
            tag.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 태그입니다."));
            postTagRepository.save(new PostTag(information, tag.get()));
        });
        return information.getId();

    }
}
