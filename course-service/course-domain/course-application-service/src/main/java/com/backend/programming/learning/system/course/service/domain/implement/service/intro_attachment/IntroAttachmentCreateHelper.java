package com.backend.programming.learning.system.course.service.domain.implement.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.intro_attachment.CreateIntroAttachmentCommand;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.mapper.intro_attachment.IntroAttachmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class IntroAttachmentCreateHelper {

    private final CourseDomainService courseDomainService;
    private final IntroAttachmentRepository introAttachmentRepository;
    private final IntroAttachmentDataMapper introAttachmentDataMapper;

    public IntroAttachmentCreateHelper(CourseDomainService courseDomainService, IntroAttachmentRepository introAttachmentRepository, IntroAttachmentDataMapper introAttachmentDataMapper) {
        this.courseDomainService = courseDomainService;
        this.introAttachmentRepository = introAttachmentRepository;
        this.introAttachmentDataMapper = introAttachmentDataMapper;
    }

    @Transactional
    public IntroAttachment createIntroAttachment(CreateIntroAttachmentCommand createIntroAttachmentCommand) {
        IntroAttachment introAttachment = introAttachmentDataMapper.createIntroAttachmentCommandToIntroAttachment(createIntroAttachmentCommand);
        courseDomainService.createIntroAttachment(introAttachment);
        IntroAttachment introAttachmentResult = saveIntroAttachment(introAttachment);
        return introAttachmentResult;
    }

    private IntroAttachment saveIntroAttachment(IntroAttachment introAttachment) {
        IntroAttachment savedIntroAttachment = introAttachmentRepository.save(introAttachment);
        if(savedIntroAttachment == null) {
            log.error("IntroAttachment is not saved");
            throw new RuntimeException("IntroAttachment is not saved");
        }
        log.info("IntroAttachment is saved");
        return savedIntroAttachment;
    }

}
