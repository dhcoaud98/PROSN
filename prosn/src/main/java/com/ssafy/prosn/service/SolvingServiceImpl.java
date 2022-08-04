package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Comment;
import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.SolvingRequestDto;
import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.repository.profiile.status.SolvingRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SolvingServiceImpl implements SolvingService{
    private final UserService userService;
    private final UserRepository userRepository;
    private final SolvingRepository solvingRepository;


    @Override
    public Solving saveSolving(SolvingRequestDto solvingRequestDto) {
        UserResponseDto userInfo = userService.getMyInfoBySecret();
        Optional<User> user = userRepository.findById(userInfo.getId());
        Solving solving = Solving.builder()
                .user(user.get())
                .isRight(solvingRequestDto.isRight())
                .build();
        return solvingRepository.save(solving);
    }

    @Override
    public List<SolvingResponseDto> showAllSolving() {
        UserResponseDto userInfo = userService.getMyInfoBySecret();
        Long userId = userInfo.getId();
        List<SolvingResponseDto> solvings = solvingRepository.findSolvingByUser(userId);
        return solvings;
    }
}
