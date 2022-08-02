package com.ssafy.prosn.repository.study;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.UserResponseDto;
import com.ssafy.prosn.dto.UserStudyListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/28
 * updated by yeomyeong on 202//08/02
 */
public interface UserStudyRepository extends JpaRepository<UserStudy, Long> {
    // 사용자별 스터디그룹 목록 (제목, 내용 20자) 조회
    @Query("select new com.ssafy.prosn.dto.UserStudyListResponseDto(s.id, s.title, substring(s.mainText,0,20)) from StudyGroup s join UserStudy u on u.studyGroup = s.id where u.user=:user")
    List<UserStudyListResponseDto> findByUserId(@Param("user") Long userId);

    UserStudy findByUserIdAndStudyGroup(Long userId, StudyGroup studyGroup);

    List<UserStudy> findByStudyGroup(StudyGroup studyGroup);

    boolean existsByUserIdAndStudyGroupId(Long userId, Long studyId);


}
