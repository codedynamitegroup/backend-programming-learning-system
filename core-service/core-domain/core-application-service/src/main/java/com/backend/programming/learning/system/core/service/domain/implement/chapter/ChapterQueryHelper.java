package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterQueryHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final ChapterRepository chapterRepository;

    public ChapterQueryHelper(CertificateCourseRepository certificateCourseRepository,
                              UserRepository userRepository,
                              ChapterRepository chapterRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.chapterRepository = chapterRepository;
    }

    @Transactional(readOnly = true)
    public List<Chapter> queryAllChapters(UUID certificateCourseId) {
        List<Chapter> chapters = chapterRepository.findAllByCertificateCourseId(
                new CertificateCourseId(certificateCourseId));

        log.info("All chapters queried for certificate course with id: {}", certificateCourseId);
        return chapters;
    }

    @Transactional(readOnly = true)
    public Chapter queryChapterById(UUID chapterId) {
        Optional<Chapter> chapter = chapterRepository.findById(new CertificateCourseId(chapterId).getValue());

        if (chapter.isEmpty()) {
            log.error("Chapter not found with id: {}", chapterId);
            throw new ChapterNotFoundException("Chapter not found with id: " + chapterId);
        }

        log.info("Chapter queried with id: {}", chapterId);
        return chapter.get();
    }
}





















