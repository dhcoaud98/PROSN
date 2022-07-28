package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.dto.UserStudyListResponseDto;
import com.ssafy.prosn.dto.UserStudyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/07/28
 */
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
    //1. 멤버들 이름 리스트를 조회한다 (리포지토리)
    //2. 스터디그룹 내용을 조회하여 dto에 담는다 (리포지토리)
    //3. 그 dto에 리스트를 넣는다 (서비스)
    //4. 반환한다.

    //내 스터디그룹 상세 내용 조회
//    @Query("select new com.ssafy.prosn.dto.UserStudyResponseDto(" +
//            "s.id, s.title, s.currentPerson, s.maxPerson, s.place, " +
//            "s.mainText, s.secretText) from StudyGroup s where s = studyGroup")
//    UserStudyResponseDto findOne(StudyGroup studyGroup);

    @Query("select u.name from UserStudy us join User u on us.user = u.id where us.studyGroup = :studyGroup")
    List<String> findMembers(@Param("studyGroup") StudyGroup studyGroup);

}
