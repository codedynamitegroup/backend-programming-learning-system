package com.backend.programming.learning.system.core.service.dataaccess.contest.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.repository.ContestJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ContestDataAccessMapper {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public ContestDataAccessMapper(UserJpaRepository userJpaRepository,
                                   UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public ContestEntity contestToContestEntity(Contest contest) {
        UserEntity createdBy = userJpaRepository
                .findById(contest.getCreatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        contest.getCreatedBy().getId().getValue() + " could not be found!")
                );
        UserEntity updatedBy = userJpaRepository
                .findById(contest.getUpdatedBy().getId().getValue())
                .orElseThrow(() -> new UserNotFoundException("User with id: " +
                        contest.getUpdatedBy().getId().getValue() + " could not be found!")
                );

        return ContestEntity.builder()
                .id(contest.getId().getValue())
                .name(contest.getName())
                .description(contest.getDescription())
                .startTime(contest.getStartTime())
                .endTime(contest.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contest.getCreatedAt())
                .updatedAt(contest.getUpdatedAt())
                .build();
    }

    public Contest contestEntityToContest(ContestEntity contestEntity) {
        User createdBy = userDataAccessMapper.userEntityToUser(contestEntity.getCreatedBy());
        User updatedBy = userDataAccessMapper.userEntityToUser(contestEntity.getUpdatedBy());
        return Contest.builder()
                .id(new ContestId(contestEntity.getId()))
                .name(contestEntity.getName())
                .description(contestEntity.getDescription())
                .startTime(contestEntity.getStartTime())
                .endTime(contestEntity.getEndTime())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .createdAt(contestEntity.getCreatedAt())
                .updatedAt(contestEntity.getUpdatedAt())
                .build();
    }
}
