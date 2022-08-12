package com.ssafy.prosn.domain.user;

import com.ssafy.prosn.oauth.Platform;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * created by seongmin on 2022/07/19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SocialUser extends User {

    private Integer oauthId;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Builder
    public SocialUser(String name, String email, Integer oauthId, Platform platform) {
        super(name, email);
        this.oauthId = oauthId;
        this.platform = platform;
    }
}
