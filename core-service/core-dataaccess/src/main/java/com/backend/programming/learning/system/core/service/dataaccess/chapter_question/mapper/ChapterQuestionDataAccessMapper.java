package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class ChapterQuestionDataAccessMapper {

    private final ChapterJpaRepository chapterJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;

    public ChapterQuestionDataAccessMapper(ChapterJpaRepository chapterJpaRepository,
                                           QuestionJpaRepository questionJpaRepository) {
        this.chapterJpaRepository = chapterJpaRepository;
        this.questionJpaRepository = questionJpaRepository;
    }

    public ChapterQuestionEntity chapterQuestionToChapterQuestionEntity(
            ChapterQuestion chapterQuestion) {
        ChapterEntity chapterEntity = chapterJpaRepository
                .findById(chapterQuestion.getChapterId().getValue())
                .orElseThrow(() -> new ChapterNotFoundException("Chapter with id: " +
                        chapterQuestion.getChapterId().getValue() + " could not be found!")
                );
        QuestionEntity questionEntity = questionJpaRepository
                .findById(chapterQuestion.getQuestionId().getValue())
                .orElseThrow(() -> new QuestionNotFoundException("Question with id: " +
                        chapterQuestion.getQuestionId().getValue() + " could not be found!")
                );

        return ChapterQuestionEntity.builder()
                .id(chapterQuestion.getId().getValue())
                .chapter(chapterEntity)
                .question(questionEntity)
                .grade(chapterQuestion.getGrade())
                .pass(chapterQuestion.getPass())
                .build();
    }

    public ChapterQuestion chapterQuestionEntityToChapterQuestion(
            ChapterQuestionEntity chapterQuestionEntity) {
        return ChapterQuestion.builder()
                .id(new ChapterQuestionId(chapterQuestionEntity.getId()))
                .chapterId(new ChapterId(chapterQuestionEntity.getChapter().getId()))
                .questionId(new QuestionId(chapterQuestionEntity.getQuestion().getId()))
                .grade(chapterQuestionEntity.getGrade())
                .pass(chapterQuestionEntity.getPass())
                .build();
    }
}
