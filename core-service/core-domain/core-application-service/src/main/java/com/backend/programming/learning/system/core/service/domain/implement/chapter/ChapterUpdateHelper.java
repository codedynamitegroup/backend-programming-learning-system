package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.review.UpdateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterUpdateHelper {
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;

    public ChapterUpdateHelper(ChapterRepository chapterRepository,
                               UserRepository userRepository) {
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void persistChapter(UpdateChapterCommand updateChapterCommand) {
        User updatedByUser = getUser(updateChapterCommand.getUpdatedBy());
        Chapter chapter = getChapter(updateChapterCommand.getChapterId());

        chapter.setUpdatedBy(updatedByUser);
        chapter.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));

        if (updateChapterCommand.getNo() != null) {
            chapter.setNo(updateChapterCommand.getNo());
        }

        if (updateChapterCommand.getTitle() != null) {
            chapter.setTitle(updateChapterCommand.getTitle());
        }

        if (updateChapterCommand.getDescription() != null) {
            chapter.setDescription(updateChapterCommand.getDescription());
        }

        updateChapter(chapter);
        log.info("Chapter updated with id: {}", chapter.getId().getValue());
    }

    private Chapter getChapter(UUID chapterId) {
        Optional<Chapter> chapter = chapterRepository.findById(chapterId);
        if (chapter.isEmpty()) {
            log.error("Chapter with id: {} not found", chapterId);
            throw new CoreDomainException("Could not find chapter with id: " + chapterId);
        }
        return chapter.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private void updateChapter(Chapter chapter) {
        Chapter updatedChapter = chapterRepository.saveChapter(chapter);

        if (updatedChapter == null) {
            log.error("Could not update chapter with id: {}", chapter.getId().getValue());

            throw new CoreDomainException("Could not update chapter with id: " + chapter.getId().getValue());
        }
        log.info("Chapter updated with id: {}", chapter.getId().getValue());
    }
}





















