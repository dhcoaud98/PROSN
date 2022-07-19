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
public class SocialUser extends User {

    private String oauthId;
    private String platform;

    @Builder
    public SocialUser(String name, String email, String oauthId, String platform) {
        super(name, email);
        this.oauthId = oauthId;
        this.platform = platform;
    }
}
