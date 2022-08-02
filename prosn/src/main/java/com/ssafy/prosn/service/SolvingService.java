package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.dto.SolvingRequestDto;
import com.ssafy.prosn.dto.SolvingResponseDto;

import java.util.List;

/**
 * created by yura on 2022/08/01
 */
public interface SolvingService {
    Solving saveSolving(SolvingRequestDto solvingRequestDto);
    List<SolvingResponseDto> showAllSolving();
}
