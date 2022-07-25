package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class CommentRequestDto {
    @NotBlank(message = "사용자는 필수 입력값입니다.")
    private Long uid;
    @NotBlank(message = "게시글은 필수 입력값입니다.")
    private Long pid;
    @NotBlank(message = "댓글은 필수 입력값입니다.")
    private String mainText;

    @Builder
    public CommentRequestDto(Long uid, Long pid, String mainText) {
        this.uid = uid;
        this.pid = pid;
        this.mainText = mainText;
    }
}
