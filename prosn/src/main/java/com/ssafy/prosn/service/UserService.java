package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.*;

import java.util.List;

/**
 * created by seongmin on 2022/07/22
 * updated by seongmin on 2022/08/08
 */
public interface UserService {
    Long join(UserJoinRequestDto joinRequestDto);
    TokenDto login(UserLoginRequestDto loginRequestDto);
    UserResponseDto getMyInfoBySecret();
    LocalUser resetPwd(LocalUser user);
    List<UserRankingResponseDto> ranking();
}
