package com.ssafy.prosn.domain.user;

import com.ssafy.prosn.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * created by seongmin on 2022/07/18
 * updated by seongmin on 2022/07/19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public abstract class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(columnDefinition = "Integer default 0")
    private Integer point;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * 문제를 풀고 맞았을 경우 포인트를 얻는 메서드
     * @param point : 획득한 포인트
     * @return : 갱신된 포인트
     */
    public int earnPoints(int point) {
        return this.point + point;
    }
}
