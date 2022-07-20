package com.ssafy.prosn.domain.scrap;

import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * created by seongmin on 2022/07/20
 */
// ProblemList와 Post를 연결해주는 엔티티
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Scrap extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Scrap(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}
