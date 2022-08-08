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
 * created by yeomyeong on 2022/07/28
 * updated by yeomyeong on 2022/08/07
 */
@Getter
@ToString(callSuper = true)
public class UserStudyResponseDto extends StudyResponseDto {
    //title, currentMem, totalMem, place, members, mainText, secretText
    private Long id;
    private List<String> members;
    private String secretText;

    @Builder
    public UserStudyResponseDto(String title, int currentPerson, int maxPerson, String place, String mainText, Long id, String secretText, List<Tag> tags) {
        super(title, currentPerson, maxPerson, place, mainText, tags);
        this.id = id;
        this.secretText = secretText;
    }

    public void addMembers(List<String> members) {
        this.members = members;
    }
}
