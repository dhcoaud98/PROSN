package com.ssafy.prosn.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * created by yura on 2022/08/01
 * updated by seongmin on 2022/08/06
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SolvingRequestDto {
    @NotNull(message = "문제는 필수 입력값입니다.")
    private Long pid;
    @NotNull(message = "풀이 결과는 필수 입력값입니다.")
    private boolean right; // IsRight 로 하면 매핑 안됨.
}
