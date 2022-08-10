package com.ssafy.prosn.repository.post;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.NumberOperation;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.QPost;
import com.ssafy.prosn.domain.post.QProblem;
import com.ssafy.prosn.domain.profile.status.QSolving;
import com.ssafy.prosn.dto.PopularityProblemResponseDto;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ssafy.prosn.domain.post.QPost.*;
import static com.ssafy.prosn.domain.post.QProblem.*;
import static com.ssafy.prosn.domain.profile.status.QSolving.*;

/**
 * created by seongmin on 2022/08/10
 */
public class ProblemRepositoryImpl implements ProblemRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProblemRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PopularityProblemResponseDto> popularProblem() {
        return queryFactory
                .select(Projections.fields(PopularityProblemResponseDto.class,
                        problem.id,
                        problem.title,
                        problem.numOfLikes,
                        problem.views,
                        problem.count().as("submissionNum")
                ))
                .from(problem).join(problem.solvingList, solving)
                .groupBy(problem.id)
                .orderBy(((problem.views.divide(2)).add((problem.numOfDislikes).multiply(5)).add(problem.id.count()).multiply(3)).desc())
                .limit(3)
                .fetch();
    }
}
