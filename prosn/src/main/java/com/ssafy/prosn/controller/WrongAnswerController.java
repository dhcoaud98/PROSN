package com.ssafy.prosn.controller;

import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.service.UserService;
import com.ssafy.prosn.service.WrongAnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * created by seongmin on 2022/08/01
 * updated by seongmin on 2022/08/07
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/wrongAnswer")
public class WrongAnswerController {

    private final WrongAnswerService wrongAnswerService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid WrongAnswerRequestDto req) {
        WrongAnswer result = wrongAnswerService.save(req, userService.getMyInfoBySecret().getId());
        log.info("result = {}", result);
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    public ResponseEntity<?> write(@RequestBody @Valid WrongNoteRequestDto req) {
        wrongAnswerService.write(req, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        wrongAnswerService.delete(id, userService.getMyInfoBySecret().getId());
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    // 오답노트 전체 조회
    @GetMapping("/all")
    public ResponseEntity<?> getNote(@RequestParam Pageable pageable, boolean isWrite) {
        NoteResponseDto result = wrongAnswerService.getNote(userService.getMyInfoBySecret().getId(), pageable, isWrite);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/tag")
    public ResponseEntity<?> getNoteByTag(@RequestParam Pageable pageable, boolean isWrite, String tag) {
        NoteResponseDto result = wrongAnswerService.getNoteByTag(userService.getMyInfoBySecret().getId(), pageable, isWrite, tag);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteDetail(@PathVariable(value = "id") Long id) {
        WrongAnswerNoteDetailResponseDto result = wrongAnswerService.getNoteDetail(id, userService.getMyInfoBySecret().getId());
        log.info("result = {}", result);
        return ResponseEntity.ok(result);
    }

}
