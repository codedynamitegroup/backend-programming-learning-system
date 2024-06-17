package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceUserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterResourceUserUpsertHelper {
    private final UserRepository userRepository;
    private final ChapterResourceUserRepository chapterResourceUserRepository;
    private final ChapterResourceRepository chapterResourceRepository;

    public ChapterResourceUserUpsertHelper(UserRepository userRepository,
                                           ChapterResourceUserRepository chapterResourceUserRepository,
                                           ChapterResourceRepository chapterResourceRepository) {
        this.userRepository = userRepository;
        this.chapterResourceUserRepository = chapterResourceUserRepository;
        this.chapterResourceRepository = chapterResourceRepository;
    }

    @Transactional
    public ChapterResourceUser persistChapterResourceUser(
            CreateChapterResourceUserCommand createChapterResourceUserCommand) {
        User user = getUserByEmail(createChapterResourceUserCommand.getEmail());
        checkChapterResourceIdExists(createChapterResourceUserCommand.getChapterResourceId());

        checkChapterResourceByChapterResourceIdAndUserId(
                createChapterResourceUserCommand.getChapterResourceId(),
                user.getId().getValue());

        ChapterResourceUser chapterResourceUser = ChapterResourceUser.builder()
                .id(new ChapterResourceUserId(UUID.randomUUID()))
                .chapterResourceId(createChapterResourceUserCommand.getChapterResourceId())
                .userId(user.getId().getValue())
                .isViewed(true)
                .build();

        return saveChapterResourceUser(chapterResourceUser);
    }

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }

    private void checkChapterResourceIdExists(UUID chapterResourceId) {
        Optional<ChapterResource> chapterResource = chapterResourceRepository
                .findChapterResourceById(chapterResourceId);
        if (chapterResource.isEmpty()) {
            log.warn("ChapterResource with id: {} not found", chapterResourceId);
            throw new CoreDomainException("Could not find chapterResource with id: " + chapterResourceId);
        }
    }

    private void checkChapterResourceByChapterResourceIdAndUserId(UUID chapterResourceId, UUID userId) {
        Optional<ChapterResourceUser> chapterResourceUser = chapterResourceUserRepository
                .findChapterResourceUserByChapterResourceIdAndUserId(chapterResourceId, userId);
        if (chapterResourceUser.isPresent()) {
            log.warn("ChapterResourceUser with chapterResourceId: {} and userId: {} is already exist",
                    chapterResourceId, userId);
            throw new CoreDomainException("ChapterResourceUser with chapterResourceId: " + chapterResourceId +
                    " and userId: " + userId + " is already exist");
        }
    }

    private ChapterResourceUser saveChapterResourceUser(ChapterResourceUser chapterResourceUser) {
        ChapterResourceUser savedChapterResourceUser = chapterResourceUserRepository
                .saveChapterResourceUser(chapterResourceUser);

        if (savedChapterResourceUser == null) {
            log.error("Could not save chapterResourceUser");
            throw new CoreDomainException("Could not save chapterResourceUser");
        }
        log.info("Chapter Resource User saved with id: {}", chapterResourceUser.getId().getValue());
        return chapterResourceUser;
    }

}





















