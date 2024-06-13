package com.backend.programming.learning.system.course.service.domain.implement.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.intro_attachment.DeleteIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.intro_attachment.IntroAttachmentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
public class IntroAttachmentApplicationServiceImpl implements IntroAttachmentApplicationService {

    private final IntroAttachmentCommandHandler introAttachmentCommandHandler;

    public IntroAttachmentApplicationServiceImpl(IntroAttachmentCommandHandler introAttachmentCommandHandler) {
        this.introAttachmentCommandHandler = introAttachmentCommandHandler;
    }

    @Override
    public CreateIntroAttachmentResponse createIntroAttachment(CreateIntroAttachmentCommand createIntroAttachmentCommand) {
        return introAttachmentCommandHandler.createIntroAttachment(createIntroAttachmentCommand);
    }

    @Override
    public UpdateIntroAttachmentResponse updateIntroAttachment(UpdateIntroAttachmentCommand updateIntroAttachmentCommand, UUID id) {
        return introAttachmentCommandHandler.updateIntroAttachment(updateIntroAttachmentCommand, id);
    }

    @Override
    public DeleteIntroAttachmentResponse deleteIntroAttachment(UUID id) {
        return introAttachmentCommandHandler.deleteIntroAttachment(id);
    }

}
