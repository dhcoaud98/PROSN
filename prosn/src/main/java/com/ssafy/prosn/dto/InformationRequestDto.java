package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * created by seongmin on 2022/07/25
 */
@Getter
@ToString
public class InformationRequestDto extends PostRequestDto {
    private String mainText;

    @Builder
    public InformationRequestDto(Long uid, String title, List<String> tags, String mainText) {
        super(uid, title, tags);
        this.mainText = mainText;
    }
}
