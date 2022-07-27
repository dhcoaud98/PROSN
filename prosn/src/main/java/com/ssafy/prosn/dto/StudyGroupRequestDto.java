package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * created by yeomyeong on 2022/07/26
 * updated by yeomyeong on 2022/07/27
 */
@Getter
@ToString
public class StudyGroupRequestDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    @Min(1)
    @NotBlank(message = "최대인원수는 필수 입력 값입니다.")
    private int maxPerson;
    @FutureOrPresent
    @NotBlank(message = "마감일은 필수 입력 값입니다.")
    private LocalDate expiredDate;
    @NotBlank(message = "장소는 필수 입력 값입니다.")
    private String place;
    @NotBlank(message = "설명은 필수 입력 값입니다.")
    private String mainText;
    @NotBlank(message = "세부내용은 필수 입력 값입니다.")
    private String secretText;

    @Builder
    public StudyGroupRequestDto(String title, int maxPerson, LocalDate expiredDate, String place, String mainText, String secretText) {
        this.title = title;
        this.maxPerson = maxPerson;
        this.expiredDate = expiredDate;
        this.place = place;
        this.mainText = mainText;
        this.secretText = secretText;
    }
}
