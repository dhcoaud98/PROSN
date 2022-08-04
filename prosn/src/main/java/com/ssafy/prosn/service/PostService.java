package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.dto.*;

import java.util.List;

/**
 * created by seongmin on 2022/07/25
 * updated by seongmin on 2022/08/01
 */
public interface PostService {
    Post writeProblem(ProblemRequestDto problemDto, Long uid);
    Post writeInformation(InformationRequestDto informationDto, Long uid);
    void delete(Long id, Long uid);
    PostDetailResponseDto showProblemDetail(Long id);
    List<PostAllResponseDto> showAllPost();
    void likeDislikeClick(LikeDisLikeRequestDto likeDisLikeDto, Long uid);
    List<PostAllResponseDto> searchPost(PostSearchRequestDto searchDto);

}
