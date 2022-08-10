package com.ssafy.prosn.repository.post;

import com.querydsl.core.Tuple;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.dto.PopularityProblemResponseDto;

import java.util.List;

/**
 * created by seongmin on 2022/08/10
 */
public interface ProblemRepositoryCustom {
    List<PopularityProblemResponseDto> popularProblem();
}
