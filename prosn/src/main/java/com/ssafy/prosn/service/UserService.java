package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.TokenDto;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;
import com.ssafy.prosn.dto.UserResponseDto;

/**
 * created by seongmin on 2022/07/22
 * updated by yeomyeong on 2022/08/07 (line 19)
 */
public interface UserService {
    Long join(UserJoinRequestDto joinRequestDto);
    TokenDto login(UserLoginRequestDto loginRequestDto);

    UserResponseDto getMyInfoBySecret();

    LocalUser resetPwd(LocalUser user);
}
