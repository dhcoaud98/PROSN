package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.dto.NoteResponseDto;
import com.ssafy.prosn.dto.WrongAnswerNoteDetailResponseDto;
import com.ssafy.prosn.dto.WrongAnswerRequestDto;
import com.ssafy.prosn.dto.WrongNoteRequestDto;

import java.util.List;

/**
 * created by seongmin on 2022/07/29
 */
public interface WrongAnswerService {

    WrongAnswer save(WrongAnswerRequestDto dto, Long uid);

    void write(WrongNoteRequestDto dto, Long uid);

    void delete(Long id, Long uid);

    List<NoteResponseDto> getNote(Long uid);
    WrongAnswerNoteDetailResponseDto getNoteDetail(Long id, Long uid);
}
