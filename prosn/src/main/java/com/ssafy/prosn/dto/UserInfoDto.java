package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/08/08
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserInfoDto {
    private Long id;
    private String name;
    private Integer point;
    private Long followerCount;
    private Long followingCount;
    private List<PostInfo> postInfo;

    public static UserInfoDto of(User user, Long followerCount, Long followingCount, List<Post> posts) {
        List<PostInfo> postInfo = new ArrayList<>();
        for (Post post : posts) {
            postInfo.add(new PostInfo(post.getId(), post.getTitle(), post.getCreated(), post.getUpdated()));
        }
        return new UserInfoDto(
                user.getId(),
                user.getName(),
                user.getPoint(),
                followerCount,
                followingCount,
                postInfo
        );
    }

    private static class PostInfo {
        private Long id;
        private String title;
        private LocalDateTime created;
        private LocalDateTime updated;

        public PostInfo() {
        }

        public PostInfo(Long id, String title, LocalDateTime created, LocalDateTime updated) {
            this.id = id;
            this.title = title;
            this.created = created;
            this.updated = updated;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public LocalDateTime getCreated() {
            return created;
        }

        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public LocalDateTime getUpdated() {
            return updated;
        }

        public void setUpdated(LocalDateTime updated) {
            this.updated = updated;
        }
    }
}
