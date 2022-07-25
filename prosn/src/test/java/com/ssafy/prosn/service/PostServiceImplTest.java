package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.LikeDislike;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.PostDetailResponseDto;
import com.ssafy.prosn.dto.ProblemRequestDto;
import com.ssafy.prosn.repository.post.LikeDislikeRepository;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.post.tag.TagRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/25
 */
@SpringBootTest
@Transactional
class PostServiceImplTest {

    @Autowired
    private PostService postService;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostTagRepository postTagRepository;

    @Autowired
    private LikeDislikeRepository likeDislikeRepository;

    @BeforeEach
    void before() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("NW", "네트워크"));
        tags.add(new Tag("OS", "운영체제"));
        tags.add(new Tag("DB", "데이터베이스"));
        tags.add(new Tag("AL", "알고리즘"));
        tags.add(new Tag("DS", "자료구조"));
        tagRepository.saveAll(tags);

        userRepository.save(LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build());
    }

    @Test
    @DisplayName("문제 게시글 작성")
    void writeProblem() {
        // given
        Long uid = userRepository.findAll().get(0).getId();
        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("HTTP에 대해서")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .uid(uid)
                .build();

        // when
        Post post = postService.writeProblem(problemDto);


        //then
        assertThat(post.getId()).isEqualTo(postRepository.findById(post.getId()).get().getId());
        assertThat(postTagRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("정보 게시글 작성")
    void writeInfo() {
        // given
        InformationRequestDto infoDto = InformationRequestDto.builder()
                .title("BFS와 DFS에 대해서")
                .mainText("넓이 우선 탐색과 깊이 우선 탐색......")
                .uid(2L)
                .tags(List.of("AL", "DS"))
                .build();

        // when
        Post post = postService.writeInformation(infoDto);

        // then
        assertThat(post.getId()).isEqualTo(postRepository.findById(post.getId()).get().getId());
        assertThat(postTagRepository.findAll().size()).isEqualTo(2);

    }

    @Test
    @DisplayName("게시글 삭제")
    void delete() {
        // given
        Long uid = userRepository.findAll().get(0).getId();
        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("HTTP HTTP")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .uid(uid)
                .build();
        postService.writeProblem(problemDto);
        Long postId = postRepository.findAll().get(0).getId();
        Optional<Post> post = postRepository.findById(postId);

        // when
        postService.delete(postId);

        // then
        assertThat(post.get().isDeleted()).isTrue();
    }

    @Test
    @DisplayName("문제 디테일")
    void showProblemDetail() {
        Long uid = userRepository.findAll().get(0).getId();
        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("HTTP에 대해서")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .uid(uid)
                .build();

        Post post = postService.writeProblem(problemDto);
        PostDetailResponseDto postDetailResponseDto = postService.showProblemDetail(post.getId());

        assertThat(postDetailResponseDto.getId()).isEqualTo(post.getId());
        assertThat(postDetailResponseDto.getTags().size()).isEqualTo(1);
        assertThat(postDetailResponseDto.getNumOfLikes()).isEqualTo(0);
    }

    @Test
    @DisplayName("좋아요, 싫어요 버튼 클릭")
    void likeDislikeClick() {
        Long uid = userRepository.findAll().get(0).getId();
        ProblemRequestDto problemDto = ProblemRequestDto.builder()
                .title("HTTP에 대해서")
                .mainText("다음 중 HTTP 메소드가 아닌것은?")
                .ex1("UPDATE")
                .ex2("POST")
                .ex3("OPTION")
                .ex4("GET")
                .answer("UPDATE")
                .tags(List.of("NW"))
                .uid(uid)
                .build();

        Post post = postService.writeProblem(problemDto);
        postService.likeDislikeClick(uid, post.getId(), true);
        LikeDislike like = likeDislikeRepository.findByPostAndUser(post, userRepository.findById(uid).get()).get();
        assertThat(like.isType()).isTrue();
    }
}