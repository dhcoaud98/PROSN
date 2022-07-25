package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.PostDetailResponseDto;
import com.ssafy.prosn.dto.ProblemDetailResponseDto;
import com.ssafy.prosn.dto.ProblemRequestDto;

/**
 * created by seongmin on 2022/07/25
 */
public interface PostService {
    Post writeProblem(ProblemRequestDto problemDto);
    Post writeInformation(InformationRequestDto informationDto);
    void delete(Long id);
    PostDetailResponseDto showProblemDetail(Long id);

}
