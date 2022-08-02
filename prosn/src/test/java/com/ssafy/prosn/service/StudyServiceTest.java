package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.*;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import com.ssafy.prosn.repository.study.UserStudyRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * created by yeomyeong on 2022/07/27
 * updated by yeomyeong on 2022/08/02
 */

@SpringBootTest
@Transactional
@Rollback(false)
class StudyServiceTest {
    @Autowired
    private StudyService studyService;
    @Autowired
    private StudyGroupRepository studyGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserStudyRepository userStudyRepository;
    //create findAll findOne update delete

    @BeforeEach
    void before() {
        userRepository.save((User) new LocalUser("사용자1", "user@ssafy.com", "user1", "1234"));
        userRepository.save((User) new LocalUser("사용자2", "user@ssafy.com", "user2", "1234"));
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));

        studyService.create(new StudyGroupRequestDto(10L,"제목1", 10, LocalDate.now(), "역삼", "내용", "세부내용"),user1.getId());
        studyService.create(new StudyGroupRequestDto(11L,"제목2", 10, LocalDate.now(), "역삼", "내용", "세부내용"),user1.getId());
        studyService.create(new StudyGroupRequestDto(12L,"제목2", 10, LocalDate.now(), "역삼", "내용", "세부내용"),user2.getId());
    }
    @Test
    void 스터디그룹생성() {
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("유효하지 않은 사용자"));
        StudyGroup studyGroup = studyService.create(new StudyGroupRequestDto(20L,"스터디생성", 5, LocalDate.now(), "역삼역", "내용", "세부내용"), user1.getId());

        Assertions.assertThat(studyGroup.getUser()).isEqualTo(user1);
    }

    @Test
    void 스터디그룹목록조회() {
        List<StudyGroupListResponseDto> studyGroupListResponseDto = studyGroupRepository.showStudyGroupList();

        for (StudyGroupListResponseDto groupListResponseDto : studyGroupListResponseDto) {
            System.out.println("groupListResponseDto == " + groupListResponseDto.toString());
        }
    }

    @Test
    public void 스터디그룹상세내용조회_노가입() throws Exception {
        //given
        StudyGroup findGroup = studyGroupRepository.findById(1L).orElseThrow(()->new IllegalStateException("스터디그룹상세내용조회-studygroup NoSuchElement"));

        //when
        //스터디그룹아이디 넣으면 dto로 반환해주는 메서드 '서비스'에 작성
        StudyResponseDto showStudyGroup = studyService.showStudyGroup(null, findGroup.getId());

        //then
        System.out.println("showStudyGroup = " + showStudyGroup.toString());
    }

    @Test
    void 스터디그룹수정() {
        StudyGroup original = studyGroupRepository.findById(3L).get();
        StudyGroupRequestDto newOne = new StudyGroupRequestDto(20L,"수정된 제목", original.getMaxPerson(), original.getExpiredDate(), original.getPlace(), original.getMainText(), "수정 잘 됨?????");

        // update하기 전에 방장이랑 유저랑 같은 지 확인
        studyService.update(original.getId(), newOne);

        Assertions.assertThat(original.getTitle()).isEqualTo(newOne.getTitle());
        Assertions.assertThat(original.getSecretText()).isEqualTo(newOne.getSecretText());
    }

    @Test
    void 스터디그룹삭제() {
        //given
        StudyGroup group = studyGroupRepository.findById(1L).orElseThrow(() -> new IllegalStateException("스터디그룹삭제-studygroup NoSuchElement"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("스터디그룹삭제-user NoSuchElement"));
//        Long joinStudyId = studyService.joinStudy(user.getId(), group);

        //when
        studyService.deleteStudy(group);

        //then
        Assertions.assertThat(userStudyRepository.findByUserIdAndStudyGroup(user.getId(), group)).isEqualTo(null);
        assertThrows(NoSuchElementException.class, () -> {
            studyGroupRepository.findById(group.getId()).get();
        });
    }

    @Test
    public void 스터디가입() throws Exception {
        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user2 NoSuchElement"));

        StudyGroup studyGroup = studyGroupRepository.findById(2l).orElseThrow(() -> new IllegalArgumentException("스터디가입-studygroup NoSuchElement"));

        //when
        studyService.joinStudy(user1.getId(), studyGroup);
        studyService.joinStudy(user2.getId(), studyGroup);

        //then
        Assertions.assertThat(2).isEqualTo(userStudyRepository.findAll().size());
    }

    @Test
    public void 스터디그룹상세내용조회_가입() throws Exception {
        StudyGroup findGroup = studyGroupRepository.findById(1L).orElseThrow(()->new IllegalStateException("스터디그룹상세내용조회-studygroup NoSuchElement"));
        User user = userRepository.findById(2L).orElseThrow(() -> new IllegalStateException("스터디그룹상세내용조회-user NoSuchElement"));

        studyService.joinStudy(user.getId(), findGroup);
        StudyResponseDto studyResponseDto = studyService.showStudyGroup(user.getId(), findGroup.getId());

        System.out.println("studyResponseDto = " + studyResponseDto.toString());
    }

    @Test
    public void 내스터디목록조회() throws Exception {

        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("내스터디목록조회-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("내스터디목록조회-user2 NoSuchElement"));

        List<StudyGroup> groupList = studyGroupRepository.findAll();

        //when
        for (StudyGroup group : groupList) {
            studyService.joinStudy(user1.getId(),group);
        }
        List<UserStudyListResponseDto> user1studygroup = userStudyRepository.findByUserId(user1.getId());
        List<UserStudyListResponseDto> user2studygroup = userStudyRepository.findByUserId(user2.getId());

        for (UserStudyListResponseDto userStudyListResponseDto : user1studygroup) {
            System.out.println("userStudyListResponseDto = " + userStudyListResponseDto.toString());
        }
        //then
        Assertions.assertThat(user1studygroup.size()).isEqualTo(groupList.size());
        Assertions.assertThat(user2studygroup.size()).isEqualTo(0);

    }
    @Test
    public void 스터디탈퇴() throws Exception {
        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("스터디탈퇴-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("스터디탈퇴-user2 NoSuchElement"));

        StudyGroup studyGroup = studyGroupRepository.findById(1l).orElseThrow(() -> new IllegalArgumentException("스터디탈퇴-studygroup NoSuchElement"));

        studyService.joinStudy(user1.getId(), studyGroup);
        studyService.joinStudy(user2.getId(), studyGroup);

        //when
        studyService.removeStudy(user1.getId(), studyGroup);

        //then
        UserStudy findUserStudy = userStudyRepository.findByUserIdAndStudyGroup(user1.getId(), studyGroup);
        assertThrows(NullPointerException.class, () -> {
            userStudyRepository.findById(findUserStudy.getId()).get();
        });
    }


}