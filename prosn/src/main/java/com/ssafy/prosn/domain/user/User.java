package com.ssafy.prosn.domain.user;

import com.ssafy.prosn.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * created by seongmin on 2022/07/18
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer point;

    @Builder
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @param point : 획득한 포인트
     * @return : 갱신된 포인트
     */
    public int earnPoints(int point) {
        return this.point + point;
    }
}
