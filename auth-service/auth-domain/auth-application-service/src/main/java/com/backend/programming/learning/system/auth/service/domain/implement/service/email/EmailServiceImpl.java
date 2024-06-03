package com.backend.programming.learning.system.auth.service.domain.implement.service.email;

import com.backend.programming.learning.system.auth.service.domain.dto.method.email.MailBody;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendHtmlEmail(MailBody mailBody) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        mimeMessageHelper.setTo(mailBody.getTo());
        mimeMessageHelper.setSubject(mailBody.getSubject());
        mimeMessageHelper.setText(mailBody.getBody(), true);

        javaMailSender.send(mimeMessage);
        log.info("Send html email to email: {}", mailBody.getTo());
    }
}
