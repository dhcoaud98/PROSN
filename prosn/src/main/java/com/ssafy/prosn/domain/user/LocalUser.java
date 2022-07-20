package com.ssafy.prosn.domain.user;

import lombok.*;

import javax.persistence.Entity;

/**
 * created by seongmin on 2022/07/19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class LocalUser extends User {

    private String userId;
    private String password;

    @Builder
    public LocalUser(String name, String email, String userId, String password) {
        super(name, email);
        this.userId = userId;
        this.password = password;
    }
}
