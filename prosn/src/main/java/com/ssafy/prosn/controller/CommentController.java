package com.ssafy.prosn.controller;

import com.ssafy.prosn.dto.CommentRequestDto;
import com.ssafy.prosn.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * created by seongmin on 2022/07/29
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> write(@RequestBody @Valid CommentRequestDto req) {
        log.info("댓글 작성 req = {}", req);
        return ResponseEntity.ok(commentService.write(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
