package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.study.StudyGroup;
import com.ssafy.prosn.dto.StudyGroupRequestDto;
import com.ssafy.prosn.repository.study.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * created by yeomyeong on 2022/07/25
 * updated by yeomyeong on 2022/07/27
 */
public interface StudyService{

    public void create(StudyGroupRequestDto studyGroupdDto);
    public void update(Long studyGroupId, StudyGroupRequestDto newData);
}
