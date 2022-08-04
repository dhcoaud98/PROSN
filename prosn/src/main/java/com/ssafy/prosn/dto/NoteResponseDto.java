package com.ssafy.prosn.dto;

import lombok.*;

/**
 * created by seongmin on 2022/07/29
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class NoteResponseDto {
    private Long id;
    private String title;
    private boolean isWrite;
}
