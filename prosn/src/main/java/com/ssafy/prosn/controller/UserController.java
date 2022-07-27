package com.ssafy.prosn.controller;

import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.security.JwtUtils;
import com.ssafy.prosn.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * created by seongmin on 2022/07/27
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> getMyInfo() {
        UserResponseDto myInfoBySecurity = userService.getMyInfoBySecret();
        log.info("myInfoBySecurity = {}", myInfoBySecurity);
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserJoinRequestDto req) {
        userService.join(req);

        return ResponseEntity.ok("회원가입에 성공하였습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
