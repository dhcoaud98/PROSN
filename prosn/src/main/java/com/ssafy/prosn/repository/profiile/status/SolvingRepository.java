package com.ssafy.prosn.repository.profiile.status;

import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.dto.SolvingResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by yura on 2022/08/01
 */
public interface SolvingRepository extends JpaRepository<Solving, Long> {
    List<Solving> findSolvingByUserId(Long userId);
}
