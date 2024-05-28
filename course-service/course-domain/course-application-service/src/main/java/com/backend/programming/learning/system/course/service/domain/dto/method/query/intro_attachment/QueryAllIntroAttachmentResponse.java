package com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllIntroAttachmentResponse {

    private List<IntroAttachmentResponseEntity> attachments;
}
