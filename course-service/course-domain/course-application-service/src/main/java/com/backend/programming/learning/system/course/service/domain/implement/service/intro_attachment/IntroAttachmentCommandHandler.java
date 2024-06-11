package com.backend.programming.learning.system.course.service.domain.implement.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment.IntroAttachmentDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class IntroAttachmentCommandHandler {
    private final IntroAttachmentCreateHelper introAttachmentCreateHelper;
    private final IntroAttachmentUpdateHelper introAttachmentUpdateHelper;

    private final IntroAttachmentDataMapper introAttachmentDataMapper;

    public IntroAttachmentCommandHandler(IntroAttachmentCreateHelper introAttachmentCreateHelper, IntroAttachmentUpdateHelper introAttachmentUpdateHelper, IntroAttachmentDataMapper introAttachmentDataMapper) {
        this.introAttachmentCreateHelper = introAttachmentCreateHelper;
        this.introAttachmentUpdateHelper = introAttachmentUpdateHelper;
        this.introAttachmentDataMapper = introAttachmentDataMapper;
    }

    public CreateIntroAttachmentResponse createIntroAttachment(CreateIntroAttachmentCommand createIntroAttachmentCommand) {
        log.info("Create intro attachment command received");
        IntroAttachment introAttachment = introAttachmentCreateHelper.createIntroAttachment(createIntroAttachmentCommand);
        return introAttachmentDataMapper.introAttachmentToCreateIntroAttachmentResponse(introAttachment, "Intro attachment created successfully");
    }

    public UpdateIntroAttachmentResponse updateIntroAttachment(UpdateIntroAttachmentCommand updateIntroAttachmentCommand, UUID id) {
        log.info("Update intro attachment command received");
       introAttachmentUpdateHelper.persistIntroAttachment(updateIntroAttachmentCommand,id);
       return UpdateIntroAttachmentResponse.builder()
               .id(id)
               .fileName(updateIntroAttachmentCommand.getFileName())
               .message("Intro attachment updated successfully").build();
    }
}
