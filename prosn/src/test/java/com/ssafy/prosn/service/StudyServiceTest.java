package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.domain.study.UserStudy;
import com.ssafy.prosn.domain.user.LocalUser;
import com.ssafy.prosn.domain.user.User;
import com.ssafy.prosn.dto.StudyGroupRequestDto;
import com.ssafy.prosn.dto.StudyGroupResponseDto;
import com.ssafy.prosn.dto.StudyResponseDto;
import com.ssafy.prosn.dto.UserStudyListResponseDto;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import com.ssafy.prosn.repository.study.UserStudyRepository;
import com.ssafy.prosn.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

        studyService.create(new StudyGroupRequestDto(new LocalUser("사용자1", "user@ssafy.com", "user1", "1234").getId(),"제목1", 10, LocalDate.now(), "역삼", "내용", "세부내용"));
        studyService.create(new StudyGroupRequestDto(new LocalUser("사용자1", "user@ssafy.com", "user1", "1234").getId(),"제목2", 10, LocalDate.now(), "역삼", "내용", "세부내용"));
        studyService.create(new StudyGroupRequestDto(new LocalUser("사용자1", "user@ssafy.com", "user1", "1234").getId(),"제목2", 10, LocalDate.now(), "역삼", "내용", "세부내용"));
    }
    @Test
    void 스터디그룹생성() {
        StudyGroupRequestDto dto = new StudyGroupRequestDto(100L, "제목", 10, LocalDate.now(), "역삼", "내용", "세부내용");
        studyService.create(dto);
    }

    @Test
    void 스터디그룹목록조회() {
        List<StudyGroup> studyGroupList = studyGroupRepository.findAll();

        for (StudyGroup studyGroup : studyGroupList) {
            System.out.println("studyGroup = " + studyGroup.toString());
        }

        Assertions.assertThat(studyGroupList.size()).isEqualTo(3);
    }

    @Test
    public void 스터디그룹상세내용조회_가입() throws Exception {
        StudyGroup findGroup = studyGroupRepository.findById(1L).orElseThrow(()->new IllegalStateException("스터디그룹상세내용조회-studygroup NoSuchElement"));
        User user = userRepository.findById(2L).orElseThrow(() -> new IllegalStateException("스터디그룹상세내용조회-user NoSuchElement"));

        studyService.joinStudy(user, findGroup);
        StudyResponseDto studyResponseDto = studyService.showStudyGroup(user.getId(), findGroup.getId());

        System.out.println("studyResponseDto = " + studyResponseDto.toString());
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
        StudyGroupRequestDto newOne = new StudyGroupRequestDto(100L, "수정된 제목", original.getMaxPerson(), original.getExpiredDate(), original.getPlace(), original.getMainText(), "수정 잘 됨?????");

        // 반환값 필요?
        original.update(newOne);

        Assertions.assertThat(original.getTitle()).isEqualTo(newOne.getTitle());
        Assertions.assertThat(original.getSecretText()).isEqualTo(newOne.getSecretText());
    }

    @Test
    void 스터디그룹삭제() {
        //given
        StudyGroup group = studyGroupRepository.findById(1L).orElseThrow(() -> new IllegalStateException("스터디그룹삭제-studygroup NoSuchElement"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("스터디그룹삭제-user NoSuchElement"));
        Long joinStudyId = studyService.joinStudy(user, group);

        //when
        studyService.deleteStudy(group);

        //then
        Assertions.assertThat(userStudyRepository.findByUserAndStudyGroup(user, group)).isEqualTo(null);
        assertThrows(NoSuchElementException.class, () -> {
            studyGroupRepository.findById(group.getId()).get();
        });
    }

    @Test
    public void 스터디가입() throws Exception {
        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user2 NoSuchElement"));
        User user3 = userRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user2 NoSuchElement"));

        StudyGroup studyGroup = studyGroupRepository.findById(1l).orElseThrow(() -> new IllegalArgumentException("스터디가입-studygroup NoSuchElement"));

        //when
        studyService.joinStudy(user1, studyGroup);
        studyService.joinStudy(user2, studyGroup);
        studyService.joinStudy(user3, studyGroup);

        //then
        Assertions.assertThat(3).isEqualTo(userStudyRepository.findAll().size());
    }

    @Test
    public void 스터디탈퇴() throws Exception {
        //given
        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user2 NoSuchElement"));
        User user3 = userRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("스터디가입-user2 NoSuchElement"));

        StudyGroup studyGroup = studyGroupRepository.findById(1l).orElseThrow(() -> new IllegalArgumentException("스터디가입-studygroup NoSuchElement"));

        studyService.joinStudy(user1, studyGroup);
        studyService.joinStudy(user2, studyGroup);
        studyService.joinStudy(user3, studyGroup);

        //when
        studyService.removeStudy(user3, studyGroup);

        //then
        UserStudy findUserStudy = userStudyRepository.findByUserAndStudyGroup(user3, studyGroup);
        assertThrows(NullPointerException.class, () -> {
            userStudyRepository.findById(findUserStudy.getId()).get();
        });
    }

    @Test
    public void 내스터디목록조회() throws Exception {

        //given
        User user1 = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("내스터디목록조회-user1 NoSuchElement"));
        User user2 = userRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("내스터디목록조회-user2 NoSuchElement"));
        User user3 = userRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("내스터디목록조회-user2 NoSuchElement"));

        List<StudyGroup> groupList = studyGroupRepository.findAll();

        //when
        for (StudyGroup group : groupList) {
            studyService.joinStudy(user1,group);
            studyService.joinStudy(user3,group);
        }
        List<UserStudyListResponseDto> user1studygroup = userStudyRepository.findByUser(user1);
        List<UserStudyListResponseDto> user2studygroup = userStudyRepository.findByUser(user2);

        //then
        Assertions.assertThat(user1studygroup.size()).isEqualTo(groupList.size());
        Assertions.assertThat(user2studygroup.size()).isEqualTo(0);

    }
}