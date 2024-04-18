package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterQueryHelper {
    private final ChapterRepository chapterRepository;
    private final ChapterQuestionRepository chapterQuestionRepository;

    public ChapterQueryHelper(ChapterRepository chapterRepository,
                              ChapterQuestionRepository chapterQuestionRepository) {
        this.chapterRepository = chapterRepository;
        this.chapterQuestionRepository = chapterQuestionRepository;
    }

    @Transactional(readOnly = true)
    public List<Chapter> queryAllChapters(UUID certificateCourseId) {
        List<Chapter> chapters = chapterRepository.findAllByCertificateCourseId(
                new CertificateCourseId(certificateCourseId));

        for (Chapter chapter : chapters) {
            List<ChapterQuestion> chapterQuestions = getAllChapterQuestionsForChapter(chapter.getId().getValue());
            List<Question> questions = chapterQuestions.stream()
                    .map(ChapterQuestion::getQuestion)
                    .toList();
            chapter.setQuestions(questions);
        }

        log.info("All chapters queried for certificate course with id: {}", certificateCourseId);
        return chapters;
    }

    @Transactional(readOnly = true)
    public Chapter queryChapterById(UUID chapterId) {
        Optional<Chapter> chapter = chapterRepository.findById(chapterId);

        if (chapter.isEmpty()) {
            log.error("Chapter not found with id: {}", chapterId);
            throw new ChapterNotFoundException("Chapter not found with id: " + chapterId);
        }

        List<ChapterQuestion> chapterQuestions = getAllChapterQuestionsForChapter(chapterId);
        Chapter chapterWithQuestions = chapter.get();
        List<Question> questions = chapterQuestions.stream()
                .map(ChapterQuestion::getQuestion)
                .toList();
        chapterWithQuestions.setQuestions(questions);

        log.info("Chapter queried with id: {}", chapterId);
        return chapterWithQuestions;
    }

    private List<ChapterQuestion> getAllChapterQuestionsForChapter(UUID chapterId) {
        List<ChapterQuestion> chapterQuestions = chapterQuestionRepository
                .findAllChapterQuestionsByChapterId(chapterId);

        log.info("All questions queried for chapter with id: {}", chapterId);
        return chapterQuestions;
    }
}





















