package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.post.Post;
import com.ssafy.prosn.domain.post.Workbook;
import com.ssafy.prosn.domain.profile.scrap.PostList;
import com.ssafy.prosn.domain.profile.scrap.Scrap;
import com.ssafy.prosn.dto.ScrapResponseDto;
import com.ssafy.prosn.repository.post.PostRepository;
import com.ssafy.prosn.repository.profiile.scrap.PostListRepository;
import com.ssafy.prosn.repository.profiile.scrap.ScrapRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/08/04
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ScrapServiceImpl implements ScrapService {
    private final ScrapRepository scrapRepository;
    private final PostListRepository postListRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Scrap save(Long pid, Long lid) {
        PostList postList = postListRepository.findById(lid).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 폴더입니다."));
        Post post = postRepository.findById(pid).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시글입니다."));
        if (post instanceof Workbook) {
            throw new RuntimeException("문제집은 스크랩 할 수 없습니다.");
        }
        return scrapRepository.save(new Scrap(post, postList));
    }

    @Override
    public List<ScrapResponseDto> getScrapList(Long id) {
        PostList postList = postListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 폴더입니다."));
        List<Scrap> scraps = scrapRepository.findByPostList(postList);
        List<ScrapResponseDto> result = new ArrayList<>();
        for (Scrap scrap : scraps) {
            result.add(new ScrapResponseDto(scrap.getPost().getId(), scrap.getPost().getTitle()));
        }
        return result;
    }
}
