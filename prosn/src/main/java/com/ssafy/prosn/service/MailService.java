package com.ssafy.prosn.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * created by yeomyeong on 2022/08/04
 */
@Service
@AllArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendMail(String emailTo) {

        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
        SimpleMailMessage simpleMessage = new SimpleMailMessage();

        // 수신자 설정
        simpleMessage.setTo(emailTo);
        simpleMessage.setFrom("prosnteam@naver.com");

        // 메일 제목
        simpleMessage.setSubject("[PROSN] 임시 비밀번호 발급");

        // 메일 내용
        simpleMessage.setText("임시비밀번호: ______");

        // 메일 발송
        javaMailSender.send(simpleMessage);
    }
}