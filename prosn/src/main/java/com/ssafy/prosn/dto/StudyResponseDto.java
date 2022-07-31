package com.ssafy.prosn.dto;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

/**
 * created by yeomyeong on 2022/07/31
 */

@ToString
public class StudyResponseDto {
    private String title;
    private int currentPerson;
    private int maxPerson;
    private String place;
    private String mainText;

    public StudyResponseDto(String title, int currentPerson, int maxPerson, String place, String mainText) {
        this.title = title;
        this.currentPerson = currentPerson;
        this.maxPerson = maxPerson;
        this.place = place;
        this.mainText = mainText;
    }
}
