package com.ssafy.prosn.service;

import com.ssafy.prosn.dto.PostListFolderResponseDto;

import java.util.List;

/**
 * created by seongmin on 2022/08/04
 */
public interface PostListService {
    List<PostListFolderResponseDto> getMyPostListFolder(Long uid);
}
