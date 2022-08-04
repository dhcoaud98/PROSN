package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.profile.scrap.Scrap;
import com.ssafy.prosn.dto.ScrapResponseDto;

import java.util.List;

/**
 * created by seongmin on 2022/08/04
 */
public interface ScrapService {
    Scrap save(Long pid, Long lid); // 포스트 id와 postList(폴더) id
    List<ScrapResponseDto> getScrapList(Long id); // id는 postList(폴더) 아이디
}
