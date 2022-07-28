package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * created by seongmin on 2022/07/28
 */
@Getter
@RequiredArgsConstructor
@Builder
public class ReplyRequestDto {
    @NotBlank(message = "사용자는 필수 입력값입니다.")
    private Long uid;
    @NotBlank(message = "댓글은 필수 입력값입니다.")
    private Long cid;
    @NotBlank(message = "답글은 필수 입력값입니다.")
    private String mainText;
}
