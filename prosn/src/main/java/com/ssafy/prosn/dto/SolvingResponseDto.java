package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolvingResponseDto {
    private Long id;
    private Long userId;
    private Long postId;
    private boolean isRight;

}
