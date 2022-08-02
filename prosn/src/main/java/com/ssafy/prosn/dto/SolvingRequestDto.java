package com.ssafy.prosn.dto;

import lombok.*;

/**
 * created by yura on 2022/08/01
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SolvingRequestDto {
    private Long id;
    private Long userId;
    private Long postId;
    private String isRight;
}
