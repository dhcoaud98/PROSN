package com.ssafy.prosn.domain.study;

import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/07/27
 */

@Entity
@Getter
@ToString
public class UserStudy extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public UserStudy(User user, StudyGroup studyGroup) {
        this.user = user;
        this.studyGroup = studyGroup;
    }
}
