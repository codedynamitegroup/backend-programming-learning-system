package com.backend.programming.learning.system.course.service.domain.implement.service.intro_attachment;

import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroAttachmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class IntroAttachmentDeleteHelper {
    private final IntroAttachmentRepository introAttachmentRepository;

    public IntroAttachmentDeleteHelper(IntroAttachmentRepository introAttachmentRepository) {
        this.introAttachmentRepository = introAttachmentRepository;
    }


    @Transactional
    public void deleteIntroAttachment(UUID id) {
        introAttachmentRepository.deleteById(id);
    }


}
