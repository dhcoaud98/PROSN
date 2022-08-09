package com.ssafy.prosn.dto;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProblemWorkbookResponseDto {
    private List<Content> content = new ArrayList<>();
    private int totalPages;
    private Long totalElements;

    public static ProblemWorkbookResponseDto of(List<ProblemDto> posts, int totalPages, Long totalElements){
        ProblemWorkbookResponseDto problemWorkbookResponseDto = new ProblemWorkbookResponseDto();
        problemWorkbookResponseDto.totalElements = totalElements;
        problemWorkbookResponseDto.totalPages = totalPages;
        for (ProblemDto post : posts) {
            List<String> tags = new ArrayList<>();
            for (PostTag postTag : post.getPost().getPostTags()) {
                tags.add(postTag.getTag().getCode());
            }
            problemWorkbookResponseDto.content.add(new Content(
                    tags,
                    post.getId(),
                    post.getTitle(),
                    post.getWriterId(),
                    post.getWriterName(),
                    post.getCreated(),
                    post.getUpdated(),
                    post.getDtype(),
                    post.getNumOfLikes(),
                    post.getNumOfDislikes()
            ));
        }
        return problemWorkbookResponseDto;
    }

    private static class Content {
        private List<String> tags;
        private Long id;
        private String title;
        private Long writerId;
        private String writerName;
        private LocalDateTime created;
        private LocalDateTime updated;
        private String dtype;
        private Long numOfLikes;
        private Long numOfDislikes;

        public Content(List<String> tags, Long id, String title, Long writerId, String writerName, LocalDateTime created, LocalDateTime updated, String dtype, Long numOfLikes, Long numOfDislikes) {
            this.tags = tags;
            this.id = id;
            this.title = title;
            this.writerId = writerId;
            this.writerName = writerName;
            this.created = created;
            this.updated = updated;
            this.dtype = dtype;
            this.numOfLikes = numOfLikes;
            this.numOfDislikes = numOfDislikes;
        }
        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
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

        public Long getWriterId() {
            return writerId;
        }

        public void setWriterId(Long writerId) {
            this.writerId = writerId;
        }

        public String getWriterName() {
            return writerName;
        }

        public void setWriterName(String writerName) {
            this.writerName = writerName;
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

        public String getDtype() {
            return dtype;
        }

        public void setDtype(String dtype) {
            this.dtype = dtype;
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
