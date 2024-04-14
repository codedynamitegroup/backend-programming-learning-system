package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;
    private final ChapterDataMapper chapterDataMapper;

    public ChapterCreateHelper(CoreDomainService coreDomainService,
                               ChapterRepository chapterRepository,
                               UserRepository userRepository,
                               ChapterDataMapper chapterDataMapper) {
        this.coreDomainService = coreDomainService;
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
        this.chapterDataMapper = chapterDataMapper;
    }

    @Transactional
    public Chapter persistChapter(CreateChapterCommand createChapterCommand) {
        checkUser(createChapterCommand.getCreatedBy());
        checkUser(createChapterCommand.getUpdatedBy());

        Chapter chapter = chapterDataMapper.
                createChapterCommandToChapter(createChapterCommand);
        coreDomainService.createChapter(chapter);
        Chapter chapterResult = saveChapter(chapter);

        log.info("Chapter created with id: {}", chapterResult.getId().getValue());
        return chapterResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private Chapter saveChapter(Chapter chapter) {
        Chapter savedChapter = chapterRepository
                .saveChapter(chapter);

        if (savedChapter == null) {
            log.error("Could not save chapter");

            throw new CoreDomainException("Could not save chapter");
        }
        log.info("Chapter saved with id: {}", savedChapter.getId().getValue());
        return savedChapter;
    }
}





















