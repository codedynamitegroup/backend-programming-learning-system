package com.backend.programming.learning.system.course.service.domain.ports.input.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.intro_attachment.DeleteIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.intro_attachment.UpdateIntroAttachmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import jakarta.validation.Valid;

import java.util.UUID;

public interface IntroAttachmentApplicationService {

    CreateIntroAttachmentResponse createIntroAttachment(@Valid CreateIntroAttachmentCommand createIntroAttachmentCommand);

    UpdateIntroAttachmentResponse updateIntroAttachment(@Valid UpdateIntroAttachmentCommand updateIntroAttachmentCommand, UUID id);

    DeleteIntroAttachmentResponse deleteIntroAttachment(UUID id);
}
