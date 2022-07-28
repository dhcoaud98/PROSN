package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.StudyGroupRequestDto;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
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
 * updated by yeomyeong on 2022/07/28
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {

    private final StudyGroupRepository studyGroupRepository;
    private final UserRepository userRepository;
    private final EntityManager em;

    //MyStudy - 가입(cur추가), all 조회, 탈퇴(cur제거)
    //userStudyRepo.save(uid, sgid);
    //userStudyRepo.findById(uid);
    //userStudyRepo.deleteByUidAndSgid(uid, sgid);

    /**
     * 스터디 생성
     *
     * @param studyGroupDto
     */
    @Transactional
    public void create(StudyGroupRequestDto studyGroupDto) {
        User user = userRepository.findById(studyGroupDto.getUid()).get();

        StudyGroup studyGroup = StudyGroup.builder().title(studyGroupDto.getTitle())
                .mainText(studyGroupDto.getMainText())
                .maxPerson(studyGroupDto.getMaxPerson())
                .secretText(studyGroupDto.getSecretText())
                .expiredDate(studyGroupDto.getExpiredDate())
                .place(studyGroupDto.getPlace())
                .build();
        studyGroupRepository.save(studyGroup);

        UserStudy userStudy = new UserStudy(user, studyGroup);
        em.persist(userStudy);
    }

    /**
     * 스터디 상세 내용 수정
     *
     * @param studyGroupId
     * @param newData
     */
    @Transactional
    public void update(Long studyGroupId, StudyGroupRequestDto newData) {
        StudyGroup oldData = studyGroupRepository.findById(studyGroupId).get();
        oldData.update(newData);
    }
}
