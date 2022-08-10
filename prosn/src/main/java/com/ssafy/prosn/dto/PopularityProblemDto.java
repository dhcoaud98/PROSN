package com.ssafy.prosn.dto;

import lombok.*;

/**
 * created by seongmin on 2022/08/10
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class PopularityProblemResponseDto {
    private Long id;
    private String title;
    private Long numOfLikes;
    private Integer views;
    private Long submissionNum;

    public static PopularityProblemResponseDto of(Long id, String title, Long numOfLikes, Integer views, Long submissionNum) {
        return new PopularityProblemResponseDto(id, title, numOfLikes, views, submissionNum);
    }
}
