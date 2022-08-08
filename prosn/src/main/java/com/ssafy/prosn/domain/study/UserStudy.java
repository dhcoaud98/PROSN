package com.ssafy.prosn.domain.study;

import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.user.Member;
import com.ssafy.prosn.dto.UserResponseDto;
import lombok.*;

import javax.persistence.*;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/08/02
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserStudy extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member user;

    @Builder
    public UserStudy(Member user, StudyGroup studyGroup) {
        this.user = user;
        this.studyGroup = studyGroup;
    }
}
