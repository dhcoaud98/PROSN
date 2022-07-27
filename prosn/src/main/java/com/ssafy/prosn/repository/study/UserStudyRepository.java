package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * created by yeomyeong on 2022/07/27
 */
public interface UserStudyRepository extends JpaRepository<UserStudy, Long>, UserStudyRepositoryCustom {
//    @Query("select s.title, s.mainText from UserStudy u join StudyGroup s on u.uid = s.id where userid=?")
    List<StudyGroup> findByUser(User user);
}

//select * from UserStudy u join  StudyGroup s on u.sgId = s.sgId where u.uid = "사용자id"
//select s.name, substr(s.maintext,0,20) from USERSTUDY u join  STUDYGROUP s on u.sgid = s.Id where u.uid =1;