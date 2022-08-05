package com.ssafy.prosn.repository.profiile.scrap;

import com.ssafy.prosn.domain.profile.scrap.PostList;
import com.ssafy.prosn.domain.profile.scrap.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by seongmin on 2022/08/04
 */
public interface ScrapRepository extends JpaRepository<Scrap, Long> {
    List<Scrap> findByPostList(PostList postList);
}
