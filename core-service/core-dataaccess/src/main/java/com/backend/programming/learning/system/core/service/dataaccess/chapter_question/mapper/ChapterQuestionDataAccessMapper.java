package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChapterQuestionDataAccessMapper {

    private final ChapterJpaRepository chapterJpaRepository;
    private final QuestionJpaRepository questionJpaRepository;
    private final ChapterDataAccessMapper chapterDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public ChapterQuestionDataAccessMapper(ChapterJpaRepository chapterJpaRepository,
                                           QuestionJpaRepository questionJpaRepository,
                                           ChapterDataAccessMapper chapterDataAccessMapper,
                                           QuestionDataAccessMapper questionDataAccessMapper) {
        this.chapterJpaRepository = chapterJpaRepository;
        this.questionJpaRepository = questionJpaRepository;
        this.chapterDataAccessMapper = chapterDataAccessMapper;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public ChapterQuestionEntity chapterQuestionToChapterQuestionEntity(
            ChapterQuestion chapterQuestion) {
        ChapterEntity chapterEntity = chapterJpaRepository
                .findById(chapterQuestion.getChapter().getId().getValue())
                .orElseThrow(() -> new ChapterNotFoundException("Chapter with id: " +
                        chapterQuestion.getChapter().getId().getValue() + " could not be found!")
                );
        QuestionEntity questionEntity = questionJpaRepository
                .findById(chapterQuestion.getQuestion().getId().getValue())
                .orElseThrow(() -> new QuestionNotFoundException("Question with id: " +
                        chapterQuestion.getQuestion().getId().getValue() + " could not be found!")
                );

        return ChapterQuestionEntity.builder()
                .id(chapterQuestion.getId().getValue())
                .chapter(chapterEntity)
                .question(questionEntity)
                .build();
    }

    public ChapterQuestion chapterQuestionEntityToChapterQuestion(
            ChapterQuestionEntity chapterQuestionEntity) {
        Chapter chapter = chapterDataAccessMapper.chapterEntityToChapter(chapterQuestionEntity.getChapter());
        Question question = questionDataAccessMapper.questionEntityToQuestion(chapterQuestionEntity.getQuestion());

        return ChapterQuestion.builder()
                .id(new ChapterQuestionId(chapterQuestionEntity.getId()))
                .chapter(chapter)
                .question(question)
                .build();
    }

    public List<ChapterQuestion> chapterQuestionEntityListToChapterQuestionList(
            List<ChapterQuestionEntity> chapterQuestionEntities) {
        List<ChapterQuestion> chapterQuestions = new ArrayList<>();
        for (ChapterQuestionEntity chapterQuestionEntity : chapterQuestionEntities) {
            chapterQuestions.add(chapterQuestionEntityToChapterQuestion(chapterQuestionEntity));
        }
        return chapterQuestions;
    }
}
