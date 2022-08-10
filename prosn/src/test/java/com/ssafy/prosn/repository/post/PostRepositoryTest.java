package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.*;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.ProblemDto;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.post.tag.TagRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/20
 * updated by seongmin on 2022/07/22
 */
@Transactional
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private PostTagRepository postTagRepository;

    @BeforeEach
    void before() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("NW", "네트워크"));
        tags.add(new Tag("OS", "운영체제"));
        tags.add(new Tag("DS", "자료구조"));
        tags.add(new Tag("DB", "데이터베이스"));
        tags.add(new Tag("AL", "알고리즘"));
        tags.add(new Tag("OOP", "객체지향"));
        tags.add(new Tag("PL", "프로그래밍 언어"));
        tags.add(new Tag("CS", "컴퓨터구조"));
        tags.add(new Tag("TC", "기술동향"));
        tags.add(new Tag("SC", "보안"));
        tags.add(new Tag("ETC", "기타"));

        tagRepository.saveAll(tags);

        User user = LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@")
                .name("테스터")
                .build();

        userRepository.save(user);

        List<Post> posts = new ArrayList<>();

        posts.add(Problem.builder()
                .user(user)
                .title("HTTP 기본2")
                .mainText("다음 중 HTTP 메서드가 아닌 것을 고르시오.")
                .example1("UPDATE")
                .example2("GET")
                .example3("POST")
                .example4("DELETE")
                .answer("UPDATE")
                .build());

        posts.add(Information.builder()
                .user(user)
                .title("시간복잡도에 대해서")
                .mainText("시간복잡도란......빅오표기법....")
                .build());

        posts.add(Problem.builder()
                .user(user)
                .title("알고리즘 시간복잡도")
                .mainText("다음 중 시간복잡도가 옳지 않은 것은?")
                .example1("옳지 않음")
                .example2("맞는답2")
                .example3("맞는답3")
                .example4("맞는답4")
                .answer("옳지 않음")
                .build());

        postRepository.saveAll(posts);

        Post post1 = postRepository.findById(posts.get(0).getId()).get();
        Post post2 = postRepository.findById(posts.get(1).getId()).get();
        Post post3 = postRepository.findById(posts.get(2).getId()).get();

        Tag nw = tagRepository.findById(tags.get(0).getId()).get();
        Tag al = tagRepository.findById(tags.get(4).getId()).get();

        postTagRepository.save(new PostTag(post1, nw));
        postTagRepository.save(new PostTag(post2, al));
        postTagRepository.save(new PostTag(post3, al));

    }

    @Test
    @DisplayName("게시글 작성")
    void save() {

        User user = LocalUser.builder()
                .userId("saveTest")
                .email("tsave@gmail.com")
                .password("qwert1234@@")
                .name("saveTester")
                .build();
        Post post = Problem.builder()
                .user(user)
                .title("HTTP")
                .mainText("다음 중 HTTP 메서드가 아닌 것을 고르시오.")
                .example1("UPDATE")
                .example2("GET")
                .example3("POST")
                .example4("DELETE")
                .answer("UPDATE")
                .build();

        User saveUser = userRepository.save(user);
        Post savePost = postRepository.save(post);

        Post findPost = postRepository.findById(post.getId()).get();
        User findUser = userRepository.findById(user.getId()).get();
        assertThat(findPost).isEqualTo(savePost);
        assertThat(findUser.getPoint()).isEqualTo(0);

    }

    @Test
    @DisplayName("게시글 검색(태그와 제목명으로)")
    void search() {
        Page<ProblemDto> result1 = postRepository.searchPost(false, PageRequest.of(0, 3), "HTTP", "NW", PostType.Problem);
        assertThat(result1.getContent().size()).isEqualTo(1);

        Page<ProblemDto> result2 = postRepository.searchPost(false, PageRequest.of(0, 3), null, "AL", PostType.Problem);
        assertThat(result2.getContent().size()).isEqualTo(2);

        Page<ProblemDto> result3 = postRepository.searchPost(false, PageRequest.of(0, 3), "시간복잡도", null, PostType.Problem);
        assertThat(result3.getContent().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("게시글 삭제")
    void delete() {
        Post post = postRepository.findById(1L).get();
        post.remove();
        List<Post> all = postRepository.findAllPost();
        assertThat(all.size()).isEqualTo(2);
    }
}