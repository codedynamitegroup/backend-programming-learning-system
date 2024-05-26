package com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_attachment.QueryAllIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_file.QueryAllIntroFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_file.IntroFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntroAttachmentDataMapper {
    QueryAllIntroAttachmentResponse introAttachmentToQueryAllIntroAttachmentResponse(List<IntroAttachment> introAttachment) {
        return QueryAllIntroAttachmentResponse.builder()
                .attachments(introAttachment.stream().map(this::introAttachmentToIntroAttachmentResponseEntity).toList())
                .build();
    }


    public IntroAttachmentResponseEntity introAttachmentToIntroAttachmentResponseEntity(IntroAttachment introAttachment) {
        return IntroAttachmentResponseEntity.builder()
                .id(introAttachment.getId().getValue())
                .fileName(introAttachment.getFileName())
                .fileSize(introAttachment.getFileSize())
                .timemodified(introAttachment.getTimemodified())
                .mimetype(introAttachment.getMimetype())
                .fileUrl(introAttachment.getFileUrl())
                .build();
    }
}
