package com.ssafy.prosn.controller;

import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.dto.UserJoinRequestDto;
import com.ssafy.prosn.dto.UserLoginRequestDto;
import com.ssafy.prosn.dto.UserResetPasswordRequestDto;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.repository.user.LocalUserRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import com.ssafy.prosn.security.JwtUtils;
import com.ssafy.prosn.service.MailService;
import com.ssafy.prosn.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * created by seongmin on 2022/07/27
 * updated by yeomyeong on 2022/08/07 (line 51~)
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final LocalUserRepository localUserRepository;

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

    @PostMapping("/resetPwd")
    public ResponseEntity<?> resetPassword(@RequestBody UserResetPasswordRequestDto reqDto) {
        LocalUser resetUser = localUserRepository.findByUserId(reqDto.getUserId())
                .orElseThrow(() -> new IllegalStateException("등록된 회원 정보가 없습니다."));

        if(!reqDto.getEmail().equals(localUserRepository.findEmailByUserId(resetUser.getUserId())))
            throw new IllegalStateException("등록된 회원 정보가 없습니다.");

        userService.resetPwd(resetUser);
        return ResponseEntity.ok("임시 비밀번호 발급 완료. 등록된 메일을 확인해주세요");
    }

    //비번 변경하는 것도 만들어야 할 것 같음
}
