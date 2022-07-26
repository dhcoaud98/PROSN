package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/25
 */
public interface StudyService{

    public void create(StudyGroup studyGroup);
    public List<StudyGroup> list();
    public StudyGroup findOne(Long studyGroupId);
    public void update(Long studyGroupId, StudyGroup newData);
    public void delete(Long studyGroupId);
}
