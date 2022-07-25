package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * created by seongmin on 2022/07/25
 */
@RequiredArgsConstructor
@Getter
@ToString
public class InformationRequestDto {
    private Long uid;
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    private String mainText;
    private List<String> tags;

    @Builder
    public InformationRequestDto(Long uid, String title, String mainText, List<String> tags) {
        this.uid = uid;
        this.title = title;
        this.mainText = mainText;
        this.tags = tags;
    }
}
