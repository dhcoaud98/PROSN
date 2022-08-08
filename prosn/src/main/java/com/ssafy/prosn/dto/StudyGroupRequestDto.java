package com.ssafy.prosn.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * created by yeomyeong on 2022/07/26
 * updated by yeomyeong on 2022/08/01
 */
@Getter
public class StudyGroupRequestDto {
    @NotNull(message = "id는 필수 입력 값입니다.")
    private Long id;
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;
    @Min(1)
    @NotNull(message = "최대인원수는 필수 입력 값입니다.")
    private int maxPerson;
    private LocalDate expiredDate;
    @NotBlank(message = "장소는 필수 입력 값입니다.")
    private String place;
    @NotBlank(message = "설명은 필수 입력 값입니다.")
    private String mainText;
    @NotBlank(message = "세부내용은 필수 입력 값입니다.")
    private String secretText;

    @Builder
    public StudyGroupRequestDto(Long id, String title, int maxPerson, LocalDate expiredDate, String place, String mainText, String secretText) {
        this.id = id;
        this.title = title;
        this.maxPerson = maxPerson;
        this.expiredDate = expiredDate;
        this.place = place;
        this.mainText = mainText;
        this.secretText = secretText;
    }
}
