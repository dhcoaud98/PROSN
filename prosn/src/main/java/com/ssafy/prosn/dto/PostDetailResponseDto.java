package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.PostType;
import com.ssafy.prosn.domain.post.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/07/25
 * updated by seongmin on 2022/08/04
 */
@Getter
@RequiredArgsConstructor
public class PostDetailResponseDto {
    private Long id;
    private String title;
    private Long numOfLikes;
    private Long numOfDislikes;
    private List<Comment> comments = new ArrayList<>();
    private Integer views;
    private UserResponseDto user;
    private List<Tag> tags;
    private PostType type;

    public PostDetailResponseDto(Long id, String title, Long numOfLikes, Long numOfDislikes, List<Comment> comments, Integer views, UserResponseDto user, List<Tag> tags, PostType type) {
        this.id = id;
        this.title = title;
        this.numOfLikes = numOfLikes;
        this.numOfDislikes = numOfDislikes;
        this.comments = comments;
        this.views = views;
        this.user = user;
        this.tags = tags;
        this.type = type;
    }
}
