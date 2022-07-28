package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * created by seongmin on 2022/07/20
 * updated by seongmin on 2022/07/22
 */
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    @Query("select p from Post  p where p.isDeleted = FALSE")
    List<Post> findAllPost();
}
