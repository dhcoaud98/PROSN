package com.ssafy.prosn.repository.post;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.PostType;
import com.ssafy.prosn.domain.post.QPost;
import com.ssafy.prosn.dto.PostDto;
import com.ssafy.prosn.dto.ProblemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ssafy.prosn.domain.post.QPost.*;
import static com.ssafy.prosn.domain.post.QPostTag.*;

/**
 * created by seongmin on 2022/07/22
 */
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


// OneToMany 관계, paging / fetch join 사용 시 distinct 적용 안됨. N+1 문제..
    @Override
    public Page<ProblemDto> searchPost(boolean isDeleted, Pageable pageable, String title, String code, PostType dtype) {
        List<ProblemDto> result = queryFactory
                .select(Projections.fields(ProblemDto.class,
                        post,
                        post.id,
                        post.title,
                        post.user.id.as("writerId"),
                        post.user.name.as("writerName"),
                        post.created,
                        post.updated,
                        post.ptype,
                        post.numOfLikes,
                        post.numOfDislikes
                )).distinct()
                .from(post)
                .leftJoin(post.postTags, postTag)
                .where(titleContains(title), codeEq(code), typeEq(dtype))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Page<ProblemDto> getProblemWorkbook(boolean isDeleted, Pageable pageable) {
        List<ProblemDto> result = queryFactory
                .select(Projections.fields(ProblemDto.class,
                        post,
                        post.id,
                        post.title,
                        post.user.id.as("writerId"),
                        post.user.name.as("writerName"),
                        post.created,
                        post.updated,
                        post.ptype,
                        post.numOfLikes,
                        post.numOfDislikes
                ))
                .from(post)
                .where(post.ptype.eq("Problem").or(post.ptype.eq("Workbook")))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, result.size());
    }

    private Predicate typeEq(PostType dtype) {
        if(String.valueOf(dtype).equals("")) {
            dtype = null;
        }
        if (dtype == null) {
            return null;
        } else if (dtype == PostType.PROBLEM) {
            return post.ptype.eq(String.valueOf(dtype)).or(post.ptype.eq(String.valueOf(PostType.WORKBOOK)));
        } else {
            return post.ptype.eq(String.valueOf(dtype));
        }

    }

    private Predicate codeEq(String code) {
        if (code.equals("")) {
            code = null;
        }
        return code != null ? postTag.tag.code.contains(code) : null;
    }

    private Predicate titleContains(String title) {
        if (title.equals("")) {
            title = null;
        }
        return title != null ? post.title.contains(title) : null;
    }
}
