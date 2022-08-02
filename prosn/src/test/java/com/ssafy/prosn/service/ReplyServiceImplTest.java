package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.comment.Reply;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.ReplyRequestDto;
import com.ssafy.prosn.repository.comment.CommentRepository;
import com.ssafy.prosn.repository.comment.ReplyRepository;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

/**
 * created by seongmin on 2022/07/28
 * updated by seongmin on 2022/08/01
 */
@SpringBootTest
@Transactional
class ReplyServiceImplTest {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @BeforeEach
    void before() {
        LocalUser saveUser = LocalUser.builder()
                .userId("test")
                .email("test@gmail.com")
                .password("qwert1234@Q")
                .name("프로즌")
                .build();
        userRepository.save(saveUser);

        Problem savePost = Problem.builder()
                .title("문제1")
                .build();
        postRepository.save(savePost);

        User user = userRepository.findById(saveUser.getId()).get();
        Post post = postRepository.findById(savePost.getId()).get();

        commentRepository.save(Comment.builder()
                .user(user)
                .post(post)
                .mainText("좋은 문제입니다.")
                .build());
    }

    @Test
    @DisplayName("답글 작성")
    void write() {
        User user = LocalUser.builder()
                .userId("prosn")
                .name("홍길동")
                .email("hong@gmail.com")
                .password("1234qwer@P")
                .build();
        userRepository.save(user);
        Comment comment = commentRepository.findAll().get(0);

        Reply reply = replyService.write(new ReplyRequestDto(comment.getId(), "인정"),user.getId());

        Reply resultReply = replyRepository.findById(reply.getId()).get();
        assertThat(reply.getId()).isEqualTo(resultReply.getId());
        assertThat(resultReply.getComment()).isEqualTo(comment);
    }

    @Test
    @DisplayName("답글 삭제")
    void delete() {
        User user = userRepository.findAll().get(0);
        Comment comment = commentRepository.findAll().get(0);

        Reply reply = replyService.write(new ReplyRequestDto(comment.getId(), "쉽네요"), user.getId());
        assertThat(replyRepository.findAll().size()).isEqualTo(1);

        replyService.delete(reply.getId(), user.getId());

        assertThat(replyRepository.findAll().size()).isEqualTo(0);
    }
}