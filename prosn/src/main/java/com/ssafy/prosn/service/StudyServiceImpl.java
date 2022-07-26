package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/26
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {
    private final StudyGroupRepository studyGroupRepository;

    //MyStudy - 가입(cur추가), all 조회, 탈퇴(cur제거)
    //userStudyRepo.save(uid, sgid);
    //userStudyRepo.findById(uid);
    //userStudyRepo.deleteByUidAndSgid(uid, sgid);

    /**
     * 스터디 생성
     *
     * @param studyGroup
     */
    @Transactional
    public void create(StudyGroup studyGroup) {
        studyGroupRepository.save(studyGroup);
    }

    /**
     * 스터디 목록 조회
     *
     * @return
     */
    public List<StudyGroup> list() {
        return studyGroupRepository.findAll();
    }

    /**
     * 스터디 상세 내용을 불러오기 위한 단건 조회
     *
     * @param studyGroupId
     * @return
     */
    public StudyGroup findOne(Long studyGroupId) {
        return studyGroupRepository.findById(studyGroupId).get();
    }

    /**
     * 스터디 상세 내용 수정
     *
     * @param studyGroupId
     * @param newData
     */
    @Transactional
    public void update(Long studyGroupId, StudyGroup newData) {
        StudyGroup oldData = studyGroupRepository.findById(studyGroupId).get();
        oldData.update(newData);
    }

    /**
     * 스터디 삭제
     *
     * @param studyGroupId
     */
    @Transactional
    public void delete(Long studyGroupId) {
        studyGroupRepository.deleteById(studyGroupId);
    }
}
