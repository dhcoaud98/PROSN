package com.ssafy.prosn.domain.post;

import com.ssafy.prosn.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;

/**
 * created by seongmin on 2022/07/19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Getter
@ToString
public class Information extends Post{

    private String mainText;

    @Builder
    public Information(String title, Integer views, User user, String mainText) {
        super(title, views, user);
        this.mainText = mainText;
    }
}
