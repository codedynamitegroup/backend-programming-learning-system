package com.backend.programming.learning.system.auth.service.domain.dto.method.email;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class MailBody {
    private final String to;
    private final String subject;
    private final String body;
}
