package com.ssafy.prosn.controller;

import com.ssafy.prosn.dto.SolvingRequestDto;
import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.service.SolvingService;
import com.ssafy.prosn.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by yura on 2022/08/01
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/solving")
public class SolvingController {

    private final SolvingService solvingService;

    /**
     * 문제풀이 현황을 DB에 저장하는 메서드
     */
    @PostMapping
    public ResponseEntity<?> saveRight(@RequestBody SolvingRequestDto req) {
        return ResponseEntity.ok(solvingService.saveSolving(req));
    }

    /**
     * 유저 아이디에 맞는 문제풀이 현황을 불러오는 메서드
     */
    @GetMapping
    public ResponseEntity<?> getAllSolving() {
        List<SolvingResponseDto> result = solvingService.showAllSolving();
        return ResponseEntity.ok(result);
    }
}
