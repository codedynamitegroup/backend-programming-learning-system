package com.backend.programming.learning.system.core.service.dataaccess.contest_question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest_question.entity.ContestQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

@Component
public class ContestQuestionDataAccessMapper {

    public ContestQuestionEntity contestQuestionToContestQuestionEntity(ContestQuestion contestQuestion) {
        return ContestQuestionEntity.builder()
                .id(contestQuestion.getId().getValue())
                .contestId(contestQuestion.getContestId().getValue())
                .questionId(contestQuestion.getQuestionId().getValue())
                .build();

    }

    public ContestQuestion contestQuestionEntityToContestQuestion(ContestQuestionEntity contestQuestionEntity) {
        return ContestQuestion.builder()
                .id(new ContestQuestionId(contestQuestionEntity.getId()))
                .contestId(new ContestId(contestQuestionEntity.getContestId()))
                .questionId(new QuestionId(contestQuestionEntity.getQuestionId()))
                .build();
    }
}
