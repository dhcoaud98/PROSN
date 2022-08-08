package com.ssafy.prosn.domain.study;

import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.user.Member;
import com.ssafy.prosn.dto.StudyGroupRequestDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/08/02
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class StudyGroup extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Member user;
    private String title;
    private String mainText;
    private String secretText;
    private String place;
    private LocalDate expiredDate;
    private int maxPerson;

    @ColumnDefault("0")
    private int currentPerson;

    @Builder
    public StudyGroup(Member user, String title, String mainText, String secretText, String place, LocalDate expiredDate, int maxPerson) {
        this.user = user;
        this.title = title;
        this.mainText = mainText;
        this.secretText = secretText;
        this.place = place;
        this.expiredDate = expiredDate;
        this.maxPerson = maxPerson;
    }
    public StudyGroup update(StudyGroupRequestDto newData) {
        this.expiredDate = newData.getExpiredDate();
        this.mainText = newData.getMainText();
        this.place = newData.getPlace();
        this.maxPerson = newData.getMaxPerson();
        this.secretText = newData.getSecretText();
        this.title = newData.getTitle();

        return this;
    }
    public void addCurrentPerson() {
        this.currentPerson++;
    }
    public void removeCurrentPerson() {
        this.currentPerson--;
    }
}
