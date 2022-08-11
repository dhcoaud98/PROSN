package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.profile.scrap.PostList;
import com.ssafy.prosn.domain.profile.scrap.Scrap;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.profiile.scrap.PostListRepository;
import com.ssafy.prosn.repository.profiile.scrap.ScrapRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/08/05
 */
@SpringBootTest
@Transactional
class ScrapServiceImplTest {
    @Autowired
    private ScrapService scrapService;
    @Autowired
    private PostListService postListService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostListRepository postListRepository;
    @Autowired
    private ScrapRepository scrapRepository;

    @BeforeEach
    void before() {
        Long uid = userService.join(UserJoinRequestDto.builder()
                .email("prosn@gmail.com")
                .name("홍길동")
                .password("qwerty123$")
                .userId("hong77")
                .build());

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
        postService.writeProblem(problemDto, uid);

        InformationRequestDto infoDto = InformationRequestDto.builder()
                .title("BFS와 DFS에 대해서")
                .mainText("넓이 우선 탐색과 깊이 우선 탐색......")
                .tags(List.of("AL", "DS"))
                .build();
        // when
        postService.writeInformation(infoDto, uid);

    }

    @Test
    @DisplayName("스크랩 폴더 만들기")
    void make() {
        // given
        User user = userRepository.findAll().get(0);

        // when
        postListService.make(user.getId(), "네트워크 모음");
        postListService.make(user.getId(), "알고리즘 모음");
        postListService.make(user.getId(), "자료구조 모음");

        // then
        assertThat(postListRepository.findAll().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("스크랩 하기")
    void scarpSave() {
        // given
        User user = userRepository.findAll().get(0);
        Long netFolderId = postListService.make(user.getId(), "네트워크 모음");
        List<Post> posts = postRepository.findAll();

        // when
        for (Post post : posts) {
            scrapService.save(post.getId(), netFolderId, user.getId());
        }

        // then
        ScrapResponseDto scrapList = scrapService.getScrapList(netFolderId, PageRequest.of(0, 3));
        assertThat(scrapList.getContent().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("스크랩 삭제")
    void deleteScrap() {
        // given
        User user = userRepository.findAll().get(0);
        Long netFolderId = postListService.make(user.getId(), "네트워크 모음");
        List<Post> posts = postRepository.findAll();
        for (Post post : posts) {
            scrapService.save(post.getId(), netFolderId, user.getId());
        }

        assertThat(scrapService.getScrapList(netFolderId,PageRequest.of(0,3)).getContent().size()).isEqualTo(2);

        PostList postList = postListRepository.findById(netFolderId).get();
        List<Scrap> scraps = scrapRepository.findByPostList(postList);

        // when
        scrapService.delete(user.getId(), scraps.get(0).getId());
        assertThat(scrapService.getScrapList(netFolderId,PageRequest.of(0,3)).getContent()).size().isEqualTo(1);
    }

}