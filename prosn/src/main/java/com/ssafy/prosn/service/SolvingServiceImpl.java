package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.PostTag;
import com.ssafy.prosn.domain.profile.status.Solving;
import com.ssafy.prosn.dto.SolvingResponseDto;
import com.ssafy.prosn.repository.post.tag.PostTagRepository;
import com.ssafy.prosn.repository.profiile.status.SolvingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yura on 2022/08/01
 * updated by yura on 2022/08/04
 */
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SolvingServiceImpl implements SolvingService{
    private final SolvingRepository solvingRepository;
//    private final PostTagRepository postTagRepository;

    @Override
    public List<SolvingResponseDto> showAllSolving(Long userId) {
        List<Solving> solvings = solvingRepository.findSolvingByUserId(userId);
        List<SolvingResponseDto> result = new ArrayList<>();

        for (Solving solving : solvings) {
            result.add(SolvingResponseDto.builder()
                    .postId(solving.getId())
                    .title(solving.getProblem().getTitle())
                    .isRight(solving.isRight())
                    .build());
        }
        return result;
    }
}
