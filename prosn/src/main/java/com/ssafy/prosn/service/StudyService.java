package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.StudyGroupRequestDto;
import com.ssafy.prosn.dto.StudyGroupResponseDto;
import com.ssafy.prosn.dto.StudyResponseDto;
import com.ssafy.prosn.dto.UserStudyResponseDto;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/08/01
 */
public interface StudyService{

    //스터디 생성
    StudyGroup create(StudyGroupRequestDto studyGroupdDto, Long uid);
    //스터디 내용 수정
    StudyGroup update(Long studyGroupId, StudyGroupRequestDto newData);
    //스터디 내용 조회
    StudyResponseDto showStudyGroup(Long userId, Long studyGroupId);
    //스터디 삭제
    void deleteStudy(StudyGroup studyGroup);
    //스터디 가입
    Long joinStudy(User user, StudyGroup studyGroup);
    //스터디 탈퇴
    void removeStudy(User user, StudyGroup studyGroup);
}
