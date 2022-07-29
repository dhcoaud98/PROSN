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
 */
@Getter
@ToString
public class StudyGroupResponseDto {
    private Long uid;
    private String title;
    private int currentPerson;
    private int maxPerson;
    private LocalDate expiredDate;
    private String place;
    private String mainText;

    @Builder
    public StudyGroupResponseDto(Long uid, String title, int currentPerson, int maxPerson, LocalDate expiredDate, String place, String mainText) {
        this.uid = uid;
        this.title = title;
        this.currentPerson = currentPerson;
        this.maxPerson = maxPerson;
        this.expiredDate = expiredDate;
        this.place = place;
        this.mainText = mainText;
    }
}
