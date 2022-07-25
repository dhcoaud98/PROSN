package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.CommentRequestDto;
import com.ssafy.prosn.repository.comment.CommentRepository;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * created by seongmin on 2022/07/25
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Comment write(CommentRequestDto commentRequestDto) {
        Optional<Post> post = postRepository.findById(commentRequestDto.getPid());
        Optional<User> user = userRepository.findById(commentRequestDto.getUid());
        post.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        user.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));

        Comment comment = Comment.builder()
                .post(post.get())
                .user(user.get())
                .mainText(commentRequestDto.getMainText())
                .build();
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void delete(Long id, Long uid) {

    }
}
