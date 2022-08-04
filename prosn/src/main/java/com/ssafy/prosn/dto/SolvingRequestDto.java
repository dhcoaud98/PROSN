package com.ssafy.prosn.dto;

import lombok.*;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SolvingRequestDto {
    private Long id;
    private Long userId;
    private Long postId;
    private boolean isRight;
}
