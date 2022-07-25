package com.ssafy.prosn.service;

import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.ProblemRequestDto;

/**
 * created by seongmin on 2022/07/25
 */
public interface PostService {
    Long writeProblem(ProblemRequestDto problemDto);
    Long writeInformation(InformationRequestDto informationDto);
}
