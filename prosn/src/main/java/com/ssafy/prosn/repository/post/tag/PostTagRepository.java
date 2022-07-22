package com.ssafy.prosn.repository.post.tag;

import com.ssafy.prosn.domain.post.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by seongmin on 2022/07/22
 */
public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}
