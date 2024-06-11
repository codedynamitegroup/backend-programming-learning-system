package com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class UpdateIntroAttachmentResponse {
    private UUID id;
    private String fileName;
    private String message;
}
