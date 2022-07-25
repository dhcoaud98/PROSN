package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.CommentRequestDto;
import com.ssafy.prosn.repository.comment.CommentRepository;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * created by seongmin on 2022/07/25
 */
@SpringBootTest
@Transactional
class CommentServiceImplTest {

    @Autowired
    CommentService commentService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void before() {
        userRepository.save(LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build());

        postRepository.save(Problem.builder()
                .title("문제1")
                .build());
    }

    @Test
    @DisplayName("댓글 작성")
    void write() {
        User user = userRepository.findAll().get(0);
        Post post = postRepository.findAll().get(0);
        CommentRequestDto commentDto = CommentRequestDto.builder()
                .uid(user.getId())
                .pid(post.getId())
                .mainText("잘봤습니다.")
                .build();
        Comment write = commentService.write(commentDto);
        Comment comment = commentRepository.findAll().get(0);
        assertThat(write).isEqualTo(comment);
    }

    @Test
    @DisplayName("댓글 삭제")
    void delete() {
        User user = userRepository.findAll().get(0);
        Post post = postRepository.findAll().get(0);

        CommentRequestDto commentDto = CommentRequestDto.builder()
                .uid(user.getId())
                .pid(post.getId())
                .mainText("잘봤습니다.")
                .build();
        Comment write = commentService.write(commentDto);

        commentService.delete(write.getId(), user.getId());

        assertThat(commentRepository.findAll().size()).isEqualTo(0);
    }
}