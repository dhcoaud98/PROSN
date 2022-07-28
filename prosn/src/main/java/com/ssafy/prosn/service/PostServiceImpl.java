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
import org.springframework.security.core.parameters.P;
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
    @Transactional
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
    @Transactional
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
    @Transactional
    public void delete(Long id) {
        Optional<Post> post = postRepository.findById(id);
        post.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        post.get().remove();
    }

    /**
     * @param id //problem id
     * @return problem detail
     * 삭제된 게시글일 경우 예외던짐. (문제집에서 확인할 때는 안던지도록 처리필요)
     */
    @Override
    public PostDetailResponseDto showProblemDetail(Long id) {
        Optional<Post> post = postRepository.findById(id);
        post.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        log.info("post type = {}", post.get().getClass());
        if(post.get() instanceof Problem) {
            log.info("문제 디테일");
            Problem problem = (Problem) post.get();
            if(problem.isDeleted()) throw new IllegalArgumentException("삭제된 게시글입니다.");
            return ProblemDetailResponseDto.builder()
                    .title(problem.getTitle())
                    .user(new UserResponseDto(problem.getUser().getId(), problem.getUser().getName()))
                    .id(problem.getId())
                    .mainText(problem.getMainText())
                    .answer(problem.getAnswer())
                    .example1(problem.getExample1())
                    .example2(problem.getExample2())
                    .example3(problem.getExample3())
                    .example4(problem.getExample4())
                    .comments(problem.getComments())
                    .numOfLikes(getNumOfLikes(problem))
                    .numOfDislikes(getNumOfDislikes(problem))
                    .views(problem.getViews())
                    .tags(getTags(problem))
                    .build();
        } else if(post.get() instanceof Information) {
            log.info("정보 디테일");
            Information information = (Information) post.get();
            if(information.isDeleted()) throw new IllegalArgumentException("삭제된 게시글입니다.");

            return InformationDetailResponseDto.builder()
                    .id(information.getId())
                    .user(new UserResponseDto(information.getUser().getId(), information.getUser().getName()))
                    .mainText(information.getMainText())
                    .comments(information.getComments())
                    .numOfDislikes(getNumOfDislikes(information))
                    .numOfLikes(getNumOfLikes(information))
                    .tags(getTags(information))
                    .views(information.getViews())
                    .build();
        } else {
            log.info("그외(문제집) 디테일");
            return null;
        }
    }

    @Override
    public List<PostAllResponseDto> showAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostAllResponseDto> result = new ArrayList<>();
        posts.forEach(post -> {
            result.add(new PostAllResponseDto(post.getId(),
                    new UserResponseDto(post.getUser().getId(),
                            post.getUser().getName()),
                            post.getTitle(),
                            post.getViews(),
                            getNumOfLikes(post),
                            getNumOfDislikes(post)));
        });
        return result;
    }

    @Override
    @Transactional
    public void likeDislikeClick(LikeDisLikeRequestDto dto) {
        Optional<User> user = userRepository.findById(dto.getUid());
        Optional<Post> post = postRepository.findById(dto.getPid());
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        post.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));

        Optional<LikeDislike> result = likeDislikeRepository.findByPostAndUser(post.get(), user.get());
        if(result.isPresent()) {
            if(result.get().isType() == dto.isType()) { // 예전에 누른거랑 같은버튼 누른 경우 삭제
                likeDislikeRepository.delete(result.get());
            } else { // 예전에 누른거랑 반대버튼 누른 경우 체인지 좋<->싫
                result.get().change();
            }
        } else {
            likeDislikeRepository.save(new LikeDislike(user.get(), post.get(), dto.isType()));
        }
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
