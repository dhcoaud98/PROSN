package com.ssafy.prosn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * created by seongmin on 2022/07/25
 */
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;

}
