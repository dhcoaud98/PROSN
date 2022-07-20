package com.ssafy.prosn.domain.scrap;

import com.ssafy.prosn.domain.BaseEntity;
import com.ssafy.prosn.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/07/20
 * updated by seongmin on 2022/07/20
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProblemList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "problemList")
    private List<Scrap> scraps = new ArrayList<>();

    @Builder
    public ProblemList(String title, User user) {
        this.title = title;
        this.user = user;
    }
}
