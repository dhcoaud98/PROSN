package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.*;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.post.LikeDislikeRepository;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.post.ProblemRepository;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.post.tag.TagRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created by seongmin on 2022/07/25
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;
    private final PostTagRepository postTagRepository;
    private final TagRepository tagRepository;
    private final LikeDislikeRepository likeDislikeRepository;
    @Override
    public Post writeProblem(ProblemRequestDto problemDto) {
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
        savePost(problemDto, problem);
        return problem;
    }

    @Override
    public Post writeInformation(InformationRequestDto informationDto) {
        Optional<User> user = userRepository.findById(informationDto.getUid());
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        Information information = Information.builder()
                .user(user.get())
                .mainText(informationDto.getMainText())
                .title(informationDto.getTitle())
                .build();

        savePost(informationDto, information);
        return information;

    }

    @Override
    public void delete(Long id) {
        Optional<Post> post = postRepository.findById(id);
        post.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        post.get().remove();
    }

    /**
     *
     * @param problem id
     * @return problem detail
     * 삭제된 게시글일 경우 예외던짐. (문제집에서 확인할 때는 안던지도록 처리필요)
     */
    @Override
    public PostDetailResponseDto showProblemDetail(Long id) {
        Optional<Problem> problem = problemRepository.findById(id);
        problem.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        if(problem.get().isDeleted()) throw new IllegalArgumentException("삭제된 게시글입니다.");

        return ProblemDetailResponseDto.builder()
                .title(problem.get().getTitle())
                .user(new UserResponseDto(problem.get().getUser().getId(), problem.get().getUser().getName()))
                .id(problem.get().getId())
                .mainText(problem.get().getMainText())
                .answer(problem.get().getAnswer())
                .example1(problem.get().getExample1())
                .example2(problem.get().getExample2())
                .example3(problem.get().getExample3())
                .example4(problem.get().getExample4())
                .comments(problem.get().getComments())
                .numOfLikes(getNumOfLikes(problem.get()))
                .numOfDislikes(getNumOfDislikes(problem.get()))
                .views(problem.get().getViews())
                .tags(getTags(problem.get()))
                .build();
    }
    private List<Tag> getTags(Post post) {
        List<PostTag> postTagByPost = postTagRepository.findPostTagByPost(post);
        List<Tag> tags = new ArrayList<>();
        postTagByPost.forEach(postTag -> {
            tags.add(postTag.getTag());
        });
        return tags;
    }

    private Long getNumOfLikes(Post post) {
        return likeDislikeRepository.countByPostAndType(post, true);
    }
    private Long getNumOfDislikes(Post post) {
        return likeDislikeRepository.countByPostAndType(post, false);
    }

    private void savePost(PostRequestDto postDto, Post post) {
        postRepository.save(post);
        postDto.getTags().forEach(code -> {
            Optional<Tag> tag = tagRepository.findByCode(code);
            tag.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 태그입니다."));
            postTagRepository.save(new PostTag(post, tag.get()));
        });
    }
}
