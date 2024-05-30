package com.backend.programming.learning.system.course.service.domain.dto.method.query.activity_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.activity_attachment.ActivityAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllActivityAttachmentResponse {

    private List<ActivityAttachmentResponseEntity> attachments;
}
