package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.Member;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import com.ssafy.prosn.repository.study.UserStudyRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/26
 * updated by yeomyeong on 2022/08/02
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyGroupRepository studyGroupRepository;
    private final UserStudyRepository userStudyRepository;
    private final UserRepository userRepository;
    private final EntityManager em;

    /**
     * 스터디 생성
     */
    @Transactional
    public StudyGroup create(StudyGroupRequestDto studyGroupDto, Long uid) {
        Member user = userRepository.findById(uid).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자입니다."));
        StudyGroup studyGroup = StudyGroup.builder()
                .title(studyGroupDto.getTitle())
                .mainText(studyGroupDto.getMainText())
                .maxPerson(studyGroupDto.getMaxPerson())
                .secretText(studyGroupDto.getSecretText())
                .expiredDate(studyGroupDto.getExpiredDate())
                .place(studyGroupDto.getPlace())
                .user(user)
                .build();

        StudyGroup save = studyGroupRepository.save(studyGroup);
        UserStudy userStudy = new UserStudy(user, studyGroup);
        em.persist(userStudy);
        return save;
    }

    /**
     * 스터디 상세 내용 수정
     */
    @Transactional
    public StudyGroup update(Long studyGroupId, StudyGroupRequestDto newData) {
        StudyGroup oldData = studyGroupRepository.findById(studyGroupId).get();
        StudyGroup updated = oldData.update(newData);
        return updated;
    }

    /**
     * 스터디 삭제
     */
    public void deleteStudy(StudyGroup studyGroup) {
        List<UserStudy> userStudyList = userStudyRepository.findByStudyGroup(studyGroup);
        for (UserStudy userStudy : userStudyList) {
            userStudyRepository.delete(userStudy);
        }
        studyGroupRepository.delete(studyGroup);
    }

    /**
     * 스터디 가입
     */
    @Transactional
    public Long joinStudy(Long userId, StudyGroup studyGroup) {
        validateDuplicate(userId, studyGroup.getId());
        Member user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("유효하지 않은 사용자입니다"));

        UserStudy userStudy = new UserStudy(user, studyGroup);
        studyGroup.addCurrentPerson();
        em.persist(userStudy);

        return userStudy.getId();
    }
    /**
     *  스터디 탈퇴
     */
    @Transactional
    public void removeStudy(Long userId, StudyGroup studyGroup) {
        if(!userStudyRepository.existsByUserIdAndStudyGroupId(userId, studyGroup.getId()))
            throw new IllegalStateException("가입되지 않은 스터디입니다.");

        UserStudy userStudy = userStudyRepository.findByUserIdAndStudyGroup(userId, studyGroup);
        studyGroup.removeCurrentPerson();
        userStudyRepository.deleteById(userStudy.getId());
    }

    /**
     * 스터디 상세 내용 조회
     */
    public StudyResponseDto showStudyGroup(Long userId, Long studyGroupId){
        StudyGroup findGroup = studyGroupRepository.findById(studyGroupId)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 스터디그룹입니다."));
        // 로그인 유저가 스터디 그룹에 가입돼 있으면
        if(userStudyRepository.existsByUserIdAndStudyGroupId(userId, studyGroupId)) {
            UserStudyResponseDto res = UserStudyResponseDto.builder()
                    .id(findGroup.getId())
                    .title(findGroup.getTitle())
                    .currentPerson(findGroup.getCurrentPerson())
                    .maxPerson(findGroup.getMaxPerson())
                    .place(findGroup.getPlace())
                    .mainText(findGroup.getMainText())
                    .secretText(findGroup.getSecretText())
                    .build();

            List<String> members = studyGroupRepository.findMembers(findGroup);
            res.addMembers(members);

            return res;
        }else {
            StudyGroupResponseDto res = StudyGroupResponseDto.builder()
                    .expiredDate(findGroup.getExpiredDate())
                    .mainText(findGroup.getMainText())
                    .maxPerson(findGroup.getMaxPerson())
                    .title(findGroup.getTitle())
                    .currentPerson(findGroup.getCurrentPerson())
                    .place(findGroup.getPlace())
                    .build();
            return res;
        }

    }
    private void validateDuplicate(Long userId, Long sgId) {
        if (userStudyRepository.existsByUserIdAndStudyGroupId(userId, sgId)) {
            throw new IllegalStateException("이미 가입된 스터디입니다.");
        }
    }

}
