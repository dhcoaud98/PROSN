package com.ssafy.prosn.controller;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.LikeDisLikeRequestDto;
import com.ssafy.prosn.dto.PostAllResponseDto;
import com.ssafy.prosn.dto.ProblemRequestDto;
import com.ssafy.prosn.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * created by seongmin on 2022/07/28
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/problem")
    public ResponseEntity<?> writeProblem(@RequestBody @Valid ProblemRequestDto req) {
        Post post = postService.writeProblem(req);
        return ResponseEntity.ok(post.getId());
    }

    @PostMapping("/information")
    public ResponseEntity<?> writeInformation(@RequestBody @Valid InformationRequestDto req) {
        Post post = postService.writeInformation(req);
        return ResponseEntity.ok(post.getId());
    }

    // 페이징 처리 추가하기
    @GetMapping
    public ResponseEntity<?> getAllPost() {
        List<PostAllResponseDto> result = postService.showAllPost();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(postService.showProblemDetail(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long id) {
        postService.delete(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PostMapping("/click")
    public ResponseEntity<?> likeDisLikeClick(@RequestBody @Valid LikeDisLikeRequestDto req) {
        postService.likeDislikeClick(req);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
