package com.ssafy.prosn.domain.study;

import com.ssafy.prosn.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * created by yeomyeong on 2022/07/25
 */
@Entity
@Getter
@ToString
public class StudyGroup extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String mainText;
    private String secretText;
    private String place;
    private LocalDate expiredDate;
    private int maxPerson;
    private int currentPerson;

    @Builder
    public StudyGroup(String title, String mainText, String secretText, String place, LocalDate expiredDate, int maxPerson) {
        this.title = title;
        this.mainText = mainText;
        this.secretText = secretText;
        this.place = place;
        this.expiredDate = expiredDate;
        this.maxPerson = maxPerson;
    }

    public void update(StudyGroup newData) {
        this.expiredDate = newData.getExpiredDate();
        this.mainText = newData.getMainText();
        this.place = newData.getPlace();
        this.maxPerson = newData.getMaxPerson();
        this.secretText = newData.getSecretText();
        this.title = newData.getTitle();
    }

}
