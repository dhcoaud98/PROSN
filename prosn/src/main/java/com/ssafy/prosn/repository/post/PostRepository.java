package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by seongmin on 2022/07/20
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
