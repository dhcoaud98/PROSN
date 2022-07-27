package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * created by yeomyeong on 2022/07/27
 */
@Transactional
@RequiredArgsConstructor
public class UserStudyRepositoryImpl implements UserStudyRepositoryCustom {

    private final EntityManager em;

    @Override
    public void joinStudy(User user, StudyGroup studyGroup) {
        UserStudy userStudy = new UserStudy(user, studyGroup);
        studyGroup.addCurrentPerson();
        em.persist(userStudy);
    }

    //@Override
    //public void removeStudy(User user, StudyGroup studyGroup) {
//        UserStudy userStudy = new UserStudy(user, studyGroup);
//        studyGroup.addCurrentPerson();
//        em.persist(userStudy);
    //}
}
