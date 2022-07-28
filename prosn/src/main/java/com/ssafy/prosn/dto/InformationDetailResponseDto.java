package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * created by seongmin on 2022/07/25
 */
@Getter
@RequiredArgsConstructor
public class InformationDetailResponseDto extends PostDetailResponseDto {

    private String mainText;

    @Builder
    public InformationDetailResponseDto(Long id, String title, Long numOfLikes, Long numOfDislikes, List<Comment> comments, Integer views, UserResponseDto user, List<Tag> tags, String mainText) {
        super(id, title, numOfLikes, numOfDislikes, comments, views, user, tags);
        this.mainText = mainText;
    }
}
