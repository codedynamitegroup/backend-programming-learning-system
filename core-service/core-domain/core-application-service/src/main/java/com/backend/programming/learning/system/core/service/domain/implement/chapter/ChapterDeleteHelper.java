package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterDeleteHelper {
    private final ChapterRepository chapterRepository;

    public ChapterDeleteHelper(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Transactional(readOnly = true)
    public void deleteChapterById(UUID chapterId) {
        checkChapterExists(chapterId);
        chapterRepository.deleteChapterById(chapterId);
    }

    private void checkChapterExists(UUID chapterId) {
        Optional<Chapter> chapter = chapterRepository.findById(chapterId);
        if (chapter.isEmpty()) {
            log.warn("Could not find chapter with id: {}", chapterId);
            throw new ChapterNotFoundException("Could not find chapter with id: " + chapterId);
        }
    }
}