package com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_attachment.QueryAllIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class IntroAttachmentDataMapper {

    private final AssignmentRepository assignmentRepository;

    public IntroAttachmentDataMapper( AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

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

    public IntroAttachment createIntroAttachmentCommandToIntroAttachment(CreateIntroAttachmentCommand createIntroAttachmentCommand) {

        Assignment assignment = null;
        if(createIntroAttachmentCommand.getAssignmentId()!=null) {
            assignment = assignmentRepository.findById(createIntroAttachmentCommand.getAssignmentId()).orElse(null);
        }

        return IntroAttachment.builder()
                .assignment(assignment)
                .fileName(createIntroAttachmentCommand.getFileName())
                .fileSize(createIntroAttachmentCommand.getFileSize())
                .timemodified(createIntroAttachmentCommand.getTimeModified())
                .mimetype(createIntroAttachmentCommand.getMimeType())
                .fileUrl(createIntroAttachmentCommand.getFileUrl())
                .build();
    }

    public CreateIntroAttachmentResponse introAttachmentToCreateIntroAttachmentResponse(IntroAttachment introAttachment, String message) {
        return CreateIntroAttachmentResponse.builder()
                .id(introAttachment.getId().getValue())
                .fileName(introAttachment.getFileName())
                .message(message)
                .build();
    }


}
