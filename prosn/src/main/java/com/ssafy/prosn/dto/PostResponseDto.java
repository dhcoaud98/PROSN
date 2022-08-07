package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Post;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/08/07
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class PostResponseDto {
    private List<Content> content = new ArrayList<>();
    private int totalPages;
    private Long totalElements;

    public void addPost(List<? extends Post> posts, int totalPages, Long totalElements) {
        for (Post post : posts) {
            this.content.add(new Content(
                    post.getId(),
                    new UserResponseDto(post.getUser().getId(),post.getUser().getName()),
                    post.getTitle(),
                    post.getViews(),
                    post.getNumOfLikes(),
                    post.getNumOfDislikes()
            ));
        }
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    private static class Content {
        private Long id;
        private UserResponseDto writer;
        private String title;
        private Integer views;
        private Long numOfLikes;
        private Long numOfDislikes;

        public Content(Long id, UserResponseDto writer, String title, Integer views, Long numOfLikes, Long numOfDislikes) {
            this.id = id;
            this.writer = writer;
            this.title = title;
            this.views = views;
            this.numOfLikes = numOfLikes;
            this.numOfDislikes = numOfDislikes;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public UserResponseDto getWriter() {
            return writer;
        }

        public void setWriter(UserResponseDto writer) {
            this.writer = writer;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public Long getNumOfLikes() {
            return numOfLikes;
        }

        public void setNumOfLikes(Long numOfLikes) {
            this.numOfLikes = numOfLikes;
        }

        public Long getNumOfDislikes() {
            return numOfDislikes;
        }

        public void setNumOfDislikes(Long numOfDislikes) {
            this.numOfDislikes = numOfDislikes;
        }
    }
}
