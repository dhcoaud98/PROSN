package com.ssafy.prosn.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * created by seongmin on 2022/07/25
 */
@Getter
public class PostRequestDto {
    @NotBlank(message = "사용자는 필수 입력 값입니다.")
    private Long uid;
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;

    @NotNull(message = "태그는 1개 이상 선택해야 합니다.")
    private List<String> tags;

    public PostRequestDto(Long uid, String title, List<String> tags) {
        this.uid = uid;
        this.title = title;
        this.tags = tags;
    }
}
