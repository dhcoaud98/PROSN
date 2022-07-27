package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.user.User;

/**
 * created by yeomyeong on 2022/07/27
 */
public interface UserStudyRepositoryCustom {
    //MyStudy - 가입(cur추가), all 조회, 상세내용을 위한 단건 조회, 탈퇴(cur제거)
    //userStudyRepo.save(uid, sgid);
    //userStudyRepo.findAll(uid, sgid);
    //userStudyRepo.findById(uid);
    //userStudyRepo.deleteByUidAndSgid(uid, sgid);

    void joinStudy(User user, StudyGroup studyGroup);
}
