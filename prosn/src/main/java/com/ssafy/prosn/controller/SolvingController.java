package com.ssafy.prosn.controller;

import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.service.SolvingService;
import com.ssafy.prosn.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/solving")
public class SolvingController {

    private final SolvingService solvingService;
    private final UserService userService;

    /**
     * 유저 아이디에 맞는 문제풀이 현황을 불러오는 메서드
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "풀이한 문제 불러오기", notes = "풀이된 문제를 불러온다.")
    public ResponseEntity<?> getAllSolving() {
        UserResponseDto userInfo = userService.getMyInfoBySecret();
        Long userId = userInfo.getId();
        List<SolvingResponseDto> result = solvingService.showAllSolving(userId);
        return ResponseEntity.ok(result);
    }
}
