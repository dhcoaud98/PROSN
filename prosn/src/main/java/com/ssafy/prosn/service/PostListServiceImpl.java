package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.profile.scrap.PostList;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.PostListFolderResponseDto;
import com.ssafy.prosn.repository.profiile.scrap.PostListRepository;
import com.ssafy.prosn.repository.user.UserRepository;
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
public class PostListServiceImpl implements PostListService {

    private final PostListRepository postListRepository;
    private final UserRepository userRepository;

    @Override
    public List<PostListFolderResponseDto> getMyPostListFolder(Long uid) {
        User user = userRepository.findById(uid).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자입니다."));
        List<PostList> postLists = postListRepository.findByUser(user);
        List<PostListFolderResponseDto> result = new ArrayList<>();
        for (PostList postList : postLists) {
            result.add(new PostListFolderResponseDto(postList.getId(), postList.getTitle()));
        }

        return result;
    }
}
