package com.ssafy.prosn.controller;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.PostType;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.service.PostService;
import com.ssafy.prosn.service.UserService;
import com.ssafy.prosn.service.WorkbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

/**
 * created by seongmin on 2022/07/28
 * updated by seongmin on 2022/08/09
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private final WorkbookService workbookService;
    private final PostRepository postRepository;

    @PostMapping("/problem")
    public ResponseEntity<?> writeProblem(@RequestBody @Valid ProblemRequestDto req) {
        Post post = postService.writeProblem(req, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(post.getId());
    }

    @PostMapping("/information")
    public ResponseEntity<?> writeInformation(@RequestBody @Valid InformationRequestDto req) {
        Post post = postService.writeInformation(req, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(post.getId());
    }

    // 페이징 처리 추가하기
    @GetMapping
    public ResponseEntity<?> getAllPost(Pageable pageable) {
        log.info("전체조회");
        PostResponseDto result = postService.showAllPost(pageable);
        return ResponseEntity.status(OK).body(result);
    }

    @GetMapping("/problem")
    public ResponseEntity<?> getAllProblem(Pageable pageable) {
        log.info("문제 전체 조회");
        ProblemWorkbookResponseDto problemWorkbookResponseDto = postService.showAllProblem(pageable);
        return ResponseEntity.status(OK).body(problemWorkbookResponseDto);

    }

    @GetMapping("/information")
    public ResponseEntity<?> getAllInformation(Pageable pageable) {
        log.info("정보 전체 조회");
        PostResponseDto result = postService.showAllInformation(pageable);
        return ResponseEntity.status(OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(value = "id") Long id, HttpServletRequest req, HttpServletResponse res) {
        log.info("조회 id = {}", id);
        Cookie oldCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("postView")) {
                    oldCookie = cookie;
                }
            }
        }
        if (oldCookie != null) {
            log.info("oldCookie.getValue() = {}", oldCookie.getValue());
            if (!oldCookie.getValue().contains("[" + id.toString() + "]")) {
                postService.updateViews(id);
                oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                res.addCookie(oldCookie);
            }
        } else {
            postService.updateViews(id);
            Cookie newCookie = new Cookie("postView", "[" + id + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            res.addCookie(newCookie);
        }
        return ResponseEntity.ok(postService.showProblemDetail(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long id) {
        log.info("삭제 id = {}", id);
        postService.delete(id, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PostMapping("/click")
    public ResponseEntity<?> likeDisLikeClick(@RequestBody @Valid LikeDisLikeRequestDto req) {
        log.info("좋아요 싫어요 req = {}", req);
        postService.likeDislikeClick(req, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String title, @RequestParam String code, @RequestParam PostType dtype, Pageable pageable) {
        log.info("title = {}", title);
        log.info("code = {}", code);
        return ResponseEntity.status(OK).body(postService.search(pageable, title, code, dtype));
    }

    @PostMapping("/workbook")
    public ResponseEntity<?> writeWorkbook(@RequestBody Map<String, String> req) {
        workbookService.save(Long.parseLong(req.get("pid")),
                userService.getMyInfoBySecret().getId(),
                req.get("title"));
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @PatchMapping("/workbook")
    public ResponseEntity<?> updateWorkbook(@RequestBody Map<String, String> req) {
        workbookService.update(userService.getMyInfoBySecret().getId(),
                Long.parseLong(req.get("wid")),
                req.get("title"));
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping("/workbook")
    public ResponseEntity<?> getAllWorkbook(Pageable pageable) {
        log.info("문제집 조회");
        PostResponseDto result = workbookService.showAllWorkbook(pageable);
        return ResponseEntity.status(OK).body(result);
    }
}
