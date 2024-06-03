package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.email.MailBody;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendHtmlEmail(MailBody mailBody) throws MessagingException;
}
