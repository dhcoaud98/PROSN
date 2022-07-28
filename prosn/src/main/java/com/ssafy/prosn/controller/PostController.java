package com.ssafy.prosn.controller;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.dto.InformationRequestDto;
import com.ssafy.prosn.dto.ProblemRequestDto;
import com.ssafy.prosn.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
