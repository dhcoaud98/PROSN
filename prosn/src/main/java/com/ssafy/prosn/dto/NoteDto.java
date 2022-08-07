package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.post.Tag;
import lombok.*;

import java.util.List;

/**
 * created by seongmin on 2022/07/29
 * updated by seongmin on 2022/08/07
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class NoteResponseDto {
    private Long id;
    private String title;
    private boolean isWrite;
}
