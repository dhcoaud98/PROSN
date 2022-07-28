package com.ssafy.prosn.domain.profile.note;

import com.ssafy.prosn.converter.BooleanToYNConverter;
import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * created by seongmin on 2022/07/22
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WrongAnswer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Problem problem;

    private String wrong_answer;

    private String reason;
    private String studyContent;
    private String memo;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isWrite;

    @Builder
    public WrongAnswer(User user, Problem problem, String wrong_answer) {
        this.user = user;
        this.problem = problem;
        this.wrong_answer = wrong_answer;
    }

    public void writeReason(String reason) {
        this.reason = reason;
    }

    public void writeStudyContent(String studyContent) {
        this.studyContent = studyContent;
    }

    public void writeMemo(String memo) {
        this.memo = memo;
    }
}