package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * created by yeomyeong on 2022/07/31
 * updated by yeomyeong on 2022/08/07
 */

@Getter
public class StudyResponseDto {
    private String title;
    private int currentPerson;
    private int maxPerson;
    private String place;
    private String mainText;
    private List<Tag> tags;

    public StudyResponseDto(String title, int currentPerson, int maxPerson, String place, String mainText, List<Tag> tags) {
        this.title = title;
        this.currentPerson = currentPerson;
        this.maxPerson = maxPerson;
        this.place = place;
        this.mainText = mainText;
        this.tags = tags;
    }
}
