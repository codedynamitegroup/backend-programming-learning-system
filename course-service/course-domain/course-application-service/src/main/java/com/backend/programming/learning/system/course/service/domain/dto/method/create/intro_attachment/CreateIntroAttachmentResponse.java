package com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateIntroAttachmentResponse {
    private UUID id;
    private String fileName;
    private String message;


}
