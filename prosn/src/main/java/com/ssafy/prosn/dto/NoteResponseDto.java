package com.ssafy.prosn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * created by seongmin on 2022/07/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class NoteResponseDto {
    private Long id;
    private String title;
    private boolean isWrite;
}
