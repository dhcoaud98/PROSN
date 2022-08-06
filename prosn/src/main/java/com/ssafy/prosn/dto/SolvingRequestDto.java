package com.ssafy.prosn.dto;

import lombok.*;

/**
 * created by yura on 2022/08/01
 * updated by seongmin on 2022/08/06
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SolvingRequestDto {
    private Long pid;
    private boolean right; // IsRight 로 하면 매핑 안됨.
}
