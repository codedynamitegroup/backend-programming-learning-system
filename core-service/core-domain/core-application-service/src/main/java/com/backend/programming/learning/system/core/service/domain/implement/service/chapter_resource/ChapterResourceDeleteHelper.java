package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterResourceNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterResourceDeleteHelper {
    private final ChapterResourceRepository chapterResourceRepository;

    public ChapterResourceDeleteHelper(ChapterResourceRepository chapterResourceRepository1) {
        this.chapterResourceRepository = chapterResourceRepository1;
    }


    @Transactional
    public void deleteChapterResourceById(UUID chapterResourceId) {
        checkChapterResourceExists(chapterResourceId);
        chapterResourceRepository.deleteChapterResource(chapterResourceId);
    }

    private void checkChapterResourceExists(UUID chapterResourceId) {
        Optional<ChapterResource> chapterResource = chapterResourceRepository
                .findChapterResourceById(chapterResourceId);
        if (chapterResource.isEmpty()) {
            log.warn("Chapter Resource with id: {} not found", chapterResource);
            throw new ChapterResourceNotFoundException("Chapter Resource with id: " + chapterResource + " not found");
        }
    }


}





















