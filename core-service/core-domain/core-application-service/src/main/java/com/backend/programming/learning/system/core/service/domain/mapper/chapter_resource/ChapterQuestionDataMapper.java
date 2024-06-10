package com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResourceResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ChapterQuestionDataMapper {
    private final UserDataMapper userDataMapper;

    public ChapterQuestionDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public ChapterQuestionResponseEntity questionToChapterQuestionResponse(Question question,
                                                                           UUID codeQuestionId) {
        UserResponseEntity createdBy = question.getCreatedBy() != null
                ? userDataMapper.userToUserResponseEntity(question.getCreatedBy())
                : null;
        UserResponseEntity updatedBy = question.getUpdatedBy() != null
                ? userDataMapper.userToUserResponseEntity(question.getUpdatedBy())
                : null;
        return ChapterQuestionResponseEntity.builder()
                .id(question.getId().getValue())
                .codeQuestionId(codeQuestionId)
                .difficulty(QuestionDifficulty.valueOf(question.getDifficulty().toString()))
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .pass(question.getPass())
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .qtype(question.getqtype())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public Question chapterQuestionResponseToQuestion(ChapterQuestionResponseEntity chapterQuestionResponse) {
        return Question.builder()
                .questionId(new QuestionId(chapterQuestionResponse.getId()))
                .difficulty(QuestionDifficulty.valueOf(chapterQuestionResponse.getDifficulty().toString()))
                .name(chapterQuestionResponse.getName())
                .questionText(chapterQuestionResponse.getQuestionText())
                .generalFeedback(chapterQuestionResponse.getGeneralFeedback())
                .defaultMark(chapterQuestionResponse.getDefaultMark())
                .pass(chapterQuestionResponse.getPass())
                .createdBy(chapterQuestionResponse.getCreatedBy() != null
                        ? userDataMapper.userResponseEntityToUser(chapterQuestionResponse.getCreatedBy())
                        : null)
                .updatedBy(chapterQuestionResponse.getUpdatedBy() != null
                        ? userDataMapper.userResponseEntityToUser(chapterQuestionResponse.getUpdatedBy())
                        : null)
                .qtype(chapterQuestionResponse.getQtype())
                .createdAt(chapterQuestionResponse.getCreatedAt())
                .updatedAt(chapterQuestionResponse.getUpdatedAt())
                .build();
    }
}
