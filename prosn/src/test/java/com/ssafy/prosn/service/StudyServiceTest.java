package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@Transactional
public class StudyServiceTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    StudyService studyService;

    @Test
    @Rollback(false)
    public void create() {
        studyService.create(StudyGroup.builder()
                .title("제목")
                .mainText("플레인")
                .expiredDate(LocalDate.now())
                .maxPerson(10)
                .place("역삼")
                .secretText("비밀")
                .build());
    }

    @Test
    public void list() {
        List<StudyGroup> list = studyService.list();
        // Assertions.assertThat() //junit5 assertj
    }

    @Test
    public void findOne() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}