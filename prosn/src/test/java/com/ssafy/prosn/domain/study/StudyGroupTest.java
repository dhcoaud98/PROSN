package com.ssafy.prosn.domain.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudyGroupTest {
    @PersistenceContext
    EntityManager em;

    @Test
    public void 스터디그룹생성() throws Exception {
        //given
        StudyGroup sg = StudyGroup.builder().place("장소").maxPerson(10).expiredDate(LocalDate.now())
                .secretText("비밀").mainText("플레인").title("제목").build();

        //when
        em.persist(sg);
        //then
        em.flush();
    }
}