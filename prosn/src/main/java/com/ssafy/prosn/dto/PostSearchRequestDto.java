package com.ssafy.prosn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * created by seongmin on 2022/07/28
 */
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PostSearchRequestDto {
    private String title;
    private String code;
}
