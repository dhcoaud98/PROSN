package com.ssafy.prosn.repository.post;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.prosn.domain.post.PostTag;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ssafy.prosn.domain.post.QPostTag.*;

/**
 * created by seongmin on 2022/07/22
 */
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PostTag> searchPost(String title, String code) {
        return queryFactory
                .selectFrom(postTag)
                .where(titleContains(title), codeEq(code))
                .fetch();
//        return queryFactory
//                .selectFrom(postTag)
//                .where(postTag.post.title.contains(title).and(postTag.tag.code.eq(code)))
//                .fetch();
    }

    private Predicate codeEq(String code) {
        return code != null ? postTag.tag.code.eq(code) : null;
    }

    private Predicate titleContains(String title) {
        return title != null ? postTag.post.title.contains(title) : null;
    }
}
