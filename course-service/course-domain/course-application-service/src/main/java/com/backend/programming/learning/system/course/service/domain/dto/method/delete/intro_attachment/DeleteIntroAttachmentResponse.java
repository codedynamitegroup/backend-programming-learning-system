package com.backend.programming.learning.system.course.service.domain.dto.method.delete.intro_attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteIntroAttachmentResponse {
    private String message;
}
