package com.backend.programming.learning.system.course.service.domain.mapper.activity_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.activity_attachment.QueryAllActivityAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_attachment.QueryAllIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.activity_attachment.ActivityAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityAttachmentDataMapper {
    QueryAllActivityAttachmentResponse activityAttachmentToQueryAllActivityAttachmentResponse(List<IntroAttachment> introAttachment) {
        return QueryAllActivityAttachmentResponse.builder()
                .attachments(introAttachment.stream().map(this::introAttachmentToIntroAttachmentResponseEntity).toList())
                .build();
    }

    ActivityAttachmentResponseEntity introAttachmentToIntroAttachmentResponseEntity(IntroAttachment introAttachment) {
        return ActivityAttachmentResponseEntity.builder()
                .id(introAttachment.getId().getValue())
                .fileName(introAttachment.getFileName())
                .fileSize(introAttachment.getFileSize())
                .timemodified(introAttachment.getTimemodified())
                .mimetype(introAttachment.getMimetype())
                .fileUrl(introAttachment.getFileUrl())
                .build();
    }

    public ActivityAttachmentResponseEntity activityAttachmentToActivityAttachmentResponseEntity(ActivityAttachment activityAttachment) {
        return ActivityAttachmentResponseEntity.builder()
                .id(activityAttachment.getId().getValue())
                .fileName(activityAttachment.getFileName())
                .fileSize(activityAttachment.getFileSize())
                .timemodified(activityAttachment.getTimemodified())
                .mimetype(activityAttachment.getMimetype())
                .fileUrl(activityAttachment.getFileUrl())
                .build();
    }
}
