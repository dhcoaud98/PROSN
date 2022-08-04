package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Tag;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SolvingResponseDto {
    private Long postId;
    private List<Tag> tagCode;
    private String title;
    private boolean isRight;
}
