package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.dto.*;

import java.util.List;

/**
 * created by seongmin on 2022/07/25
 */
public interface PostService {
    Post writeProblem(ProblemRequestDto problemDto);
    Post writeInformation(InformationRequestDto informationDto);
    void delete(Long id);
    PostDetailResponseDto showProblemDetail(Long id);
    List<PostAllResponseDto> showAllPost();
    void likeDislikeClick(Long uid, Long pid, boolean type);

}
