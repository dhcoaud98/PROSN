package com.ssafy.prosn.repository.post;

import com.ssafy.prosn.domain.post.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
