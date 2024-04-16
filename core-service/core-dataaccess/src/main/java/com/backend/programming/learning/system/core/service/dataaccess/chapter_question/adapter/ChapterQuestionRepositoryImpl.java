package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.mapper.ChapterQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.repository.ChapterQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ChapterQuestionRepositoryImpl implements ChapterQuestionRepository {
    private final ChapterQuestionJpaRepository chapterQuestionJpaRepository;
    private final ChapterQuestionDataAccessMapper chapterQuestionDataAccessMapper;

    public ChapterQuestionRepositoryImpl(ChapterQuestionJpaRepository chapterQuestionJpaRepository,
                                         ChapterQuestionDataAccessMapper chapterQuestionDataAccessMapper) {
        this.chapterQuestionJpaRepository = chapterQuestionJpaRepository;
        this.chapterQuestionDataAccessMapper = chapterQuestionDataAccessMapper;
    }

    @Override
    public ChapterQuestion saveChapterQuestion(ChapterQuestion chapterQuestion) {
        return chapterQuestionDataAccessMapper.chapterQuestionEntityToChapterQuestion(
                chapterQuestionJpaRepository.save(
                        chapterQuestionDataAccessMapper.chapterQuestionToChapterQuestionEntity(chapterQuestion)
                )
        );
    }

    @Override
    public List<ChapterQuestion> findAllChapterQuestionsByChapterId(UUID chapterId) {
        return chapterQuestionDataAccessMapper.chapterQuestionEntityListToChapterQuestionList(
                chapterQuestionJpaRepository.findAllChapterQuestionsByChapterId(chapterId)
        );
    }
}
