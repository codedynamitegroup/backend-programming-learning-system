package com.backend.programming.learning.system.core.service.domain.mapper.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ChapterDataMapper {
    private final UserRepository userRepository;

    public ChapterDataMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Chapter createChapterCommandToChapter(CreateChapterCommand createChapterCommand) {
        User createdBy = userRepository.findUser(new UserId(createChapterCommand.getCreatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createChapterCommand.getCreatedBy()));
        User updatedBy = userRepository.findUser(new UserId(createChapterCommand.getUpdatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createChapterCommand.getUpdatedBy()));
        return Chapter.builder()
                .no(createChapterCommand.getNo())
                .title(createChapterCommand.getTitle())
                .description(createChapterCommand.getDescription())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }

    public CreateChapterResponse chapterToCreateChapterResponse(Chapter chapter, String message) {
        return CreateChapterResponse.builder()
                .chapter(chapter)
                .message(message)
                .build();
    }

}
