package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.CommentRequestDto;
import com.ssafy.prosn.dto.UserResponseDto;
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
 * updated by seongmin on 2022/07/29
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserService userService;

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
    public void delete(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        comment.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 댓글입니다."));
        UserResponseDto userInfo = userService.getMyInfoBySecret();
        if (!comment.get().getUser().getId().equals(userInfo.getId()))
            throw new IllegalArgumentException("내가 쓴 댓글만 삭제 가능합니다.");

        commentRepository.deleteById(id);
    }
}
