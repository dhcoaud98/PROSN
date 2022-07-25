package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by yeomyeong on 2022/07/25
 */
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

//MyStudy - 가입(cur추가), all 조회, 탈퇴(cur제거)
    //userStudyRepo.save(uid, sgid);
    //userStudyRepo.findById(uid);
    //userStudyRepo.deleteByUidAndSgid(uid, sgid);

    //StudyGroup - 생성
    //studygroupRepo.save(sg.builder);

    // all 조회, sgRepo.findAll();
    // find() sgRepo.findById(sgid);
    // 수정 id로 조회 -> set
    // sgRepo.내가만든쿼리
    // 삭제 sgRepo.deleteById(sgid);
    // 단건 조회 sgRepo.findById(sgid);
}
