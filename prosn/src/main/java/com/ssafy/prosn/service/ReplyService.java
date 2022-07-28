package com.ssafy.prosn.service;

import com.ssafy.prosn.domain.comment.Reply;
import com.ssafy.prosn.dto.ReplyRequestDto;

/**
 * created by seongmin on 2022/07/28
 */
public interface ReplyService {
    Reply write(ReplyRequestDto replyRequestDto);

    void delete(Long id, Long uid);
}
