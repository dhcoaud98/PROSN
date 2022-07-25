package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.LikeDislike;
import com.ssafy.prosn.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {
    Long countByPostAndType(Post post, Boolean type);
}
