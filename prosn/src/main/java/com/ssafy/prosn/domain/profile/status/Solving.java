package com.ssafy.prosn.domain.profile.status;

import com.ssafy.prosn.converter.BooleanToYNConverter;
import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.user.User;
import io.swagger.annotations.ApiModelProperty;
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
public class Solving extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "문제 id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(example = "사용자 id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @ApiModelProperty(example = "게시글 id")
    private Problem problem;

    @Convert(converter = BooleanToYNConverter.class)
    @ApiModelProperty(example = "풀이 여부")
    private String isRight;

    @Builder
    public Solving(User user, Problem problem, String isRight) {
        this.user = user;
        this.problem = problem;
        this.isRight = isRight;
    }
}
