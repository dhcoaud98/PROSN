package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * created by yeomyeong on 2022/07/29
 * updated by yeomyeong on 2022/08/07
 */
@Getter
@ToString(callSuper = true)
public class StudyGroupResponseDto extends StudyResponseDto{
    private LocalDate expiredDate;

    @Builder
    public StudyGroupResponseDto(String title, int currentPerson, int maxPerson, String place, String mainText, LocalDate expiredDate, List<Tag> tags) {
        super(title, currentPerson, maxPerson, place, mainText, tags);
        this.expiredDate = expiredDate;
    }
}
