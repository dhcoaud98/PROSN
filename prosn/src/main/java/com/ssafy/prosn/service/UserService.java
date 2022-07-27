package com.ssafy.prosn.service;

import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;

/**
 * created by seongmin on 2022/07/22
 * updated by seongmin on 2022/07/27
 */
public interface UserService {
    Long join(UserJoinRequestDto joinRequestDto);
    String login(UserLoginRequestDto loginRequestDto);

}
