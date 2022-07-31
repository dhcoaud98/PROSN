package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * created by yeomyeong on 2022/07/29
 * updated by yeomyeong on 2022/07/31
 */
@ToString(callSuper = true)
public class StudyGroupResponseDto extends StudyResponseDto{
    private LocalDate expiredDate;

    @Builder
    public StudyGroupResponseDto(String title, int currentPerson, int maxPerson, String place, String mainText, LocalDate expiredDate) {
        super(title, currentPerson, maxPerson, place, mainText);
        this.expiredDate = expiredDate;
    }
}
