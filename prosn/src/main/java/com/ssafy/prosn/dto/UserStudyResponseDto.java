package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.user.User;
import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * created by yeomyeong on 2022/07/28
 */
@ToString
public class UserStudyResponseDto {
    //title, currentMem, totalMem, place, members, mainText, secretText
    private Long id;
    private String title;
    private int currentPerson;
    private int maxPerson;
    private String place;
    private List<String> members;
    private String mainText;
    private String secretText;

    @Builder
    public UserStudyResponseDto(Long id, String title, int currentPerson, int maxPerson, String place, String mainText, String secretText) {
        this.id = id;
        this.title = title;
        this.currentPerson = currentPerson;
        this.maxPerson = maxPerson;
        this.place = place;
        this.mainText = mainText;
        this.secretText = secretText;
    }

    public void addMembers(List<String> members) {
        this.members = members;
    }
}
