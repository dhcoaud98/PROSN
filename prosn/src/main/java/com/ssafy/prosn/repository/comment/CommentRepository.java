package com.ssafy.prosn.repository.comment;

import com.ssafy.prosn.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
