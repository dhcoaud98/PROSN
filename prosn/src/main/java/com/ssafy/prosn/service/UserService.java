package com.ssafy.prosn.service;

import com.ssafy.prosn.dto.UserJoinRequestDto;

/**
 * created by seongmin on 2022/07/22
 */
public interface UserService {
    Long join(UserJoinRequestDto joinRequestDto);
}
