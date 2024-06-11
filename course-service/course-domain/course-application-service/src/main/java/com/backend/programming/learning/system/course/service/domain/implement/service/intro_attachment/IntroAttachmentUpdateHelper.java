package com.backend.programming.learning.system.course.service.domain.implement.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroAttachmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class IntroAttachmentUpdateHelper {

    private final IntroAttachmentRepository introAttachmentRepository;

    private final AssignmentRepository assignmentRepository;

    public IntroAttachmentUpdateHelper(IntroAttachmentRepository introAttachmentRepository, AssignmentRepository assignmentRepository) {
        this.introAttachmentRepository = introAttachmentRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional
    public void persistIntroAttachment(UpdateIntroAttachmentCommand updateIntroAttachmentCommand,UUID id) {
        IntroAttachment introAttachment = getIntroAttachment(id);
        Assignment assignment = assignmentRepository.findById(updateIntroAttachmentCommand.getAssignmentId()).orElse(null);
        if(updateIntroAttachmentCommand.getAssignmentId() != null)
        {
            introAttachment.setAssignment(assignment);
        }
        if(updateIntroAttachmentCommand.getFileName() != null)
        {
            introAttachment.setFileName(updateIntroAttachmentCommand.getFileName());
        }
        if(updateIntroAttachmentCommand.getFileSize() != null)
        {
            introAttachment.setFileSize(updateIntroAttachmentCommand.getFileSize());
        }
        if(updateIntroAttachmentCommand.getFileUrl() != null)
        {
            introAttachment.setFileUrl(updateIntroAttachmentCommand.getFileUrl());
        }
        if(updateIntroAttachmentCommand.getMimeType() != null)
        {
            introAttachment.setMimetype(updateIntroAttachmentCommand.getMimeType());
        }
        if(updateIntroAttachmentCommand.getTimeModified() != null)
        {
            introAttachment.setTimemodified(updateIntroAttachmentCommand.getTimeModified());
        }

        saveIntroAttachment(introAttachment);
    }

    private IntroAttachment getIntroAttachment(UUID introAttachmentId) {
        return introAttachmentRepository.findById(introAttachmentId).orElseThrow(() -> {
            log.error("IntroAttachment not found");
            throw new RuntimeException("IntroAttachment not found");
        });
    }

    private void saveIntroAttachment(IntroAttachment introAttachment) {
        IntroAttachment savedIntroAttachment = introAttachmentRepository.save(introAttachment);
        if(savedIntroAttachment == null) {
            log.error("IntroAttachment is not saved");
            throw new RuntimeException("IntroAttachment is not saved");
        }
        log.info("IntroAttachment is saved");
    }
}

