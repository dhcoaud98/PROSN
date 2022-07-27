package com.ssafy.prosn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * created by seongmin on 2022/07/25
 */
@Getter
@NoArgsConstructor
public class UserLoginRequestDto {
    private String userId;
    private String password;

    public UserLoginRequestDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
