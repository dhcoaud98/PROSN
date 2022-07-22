package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostTag;

import java.util.List;

/**
 * created by seongmin on 2022/07/22
 */
public interface PostRepositoryCustom {
    List<PostTag> searchPost(String title, String code);
}
