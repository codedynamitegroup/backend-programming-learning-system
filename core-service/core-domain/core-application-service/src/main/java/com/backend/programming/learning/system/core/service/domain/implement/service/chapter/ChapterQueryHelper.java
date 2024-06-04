package com.backend.programming.learning.system.core.service.domain.implement.service.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
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
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final UserRepository userRepository;

    public ChapterQueryHelper(ChapterRepository chapterRepository,
                              ChapterQuestionRepository chapterQuestionRepository,
                              CodeSubmissionRepository codeSubmissionRepository,
                              UserRepository userRepository) {
        this.chapterRepository = chapterRepository;
        this.chapterQuestionRepository = chapterQuestionRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Chapter> queryAllChapters(UUID certificateCourseId,
                                          String email) {
        List<Chapter> chapters = chapterRepository.findAllByCertificateCourseId(
                new CertificateCourseId(certificateCourseId));

        Optional<User> user = userRepository.findByEmail(email);
        for (Chapter chapter : chapters) {
            List<ChapterQuestion> chapterQuestions = getAllChapterQuestionsForChapter(chapter.getId().getValue());
            List<Question> questions = chapterQuestions.stream()
                    .map(ChapterQuestion::getQuestion)
                    .toList();
            if (user.isPresent()) {
                for (Question question : questions) {
                    question.setPass(checkCodeQuestionIsPassed(
                            user.get().getId().getValue(),
                            question.getId().getValue(),
                            chapter.getCertificateCourseId().getValue()
                    ));
                }
            }

            chapter.setQuestions(questions);
        }

        log.info("All chapters queried for certificate course with id: {}", certificateCourseId);
        return chapters;
    }

    @Transactional(readOnly = true)
    public Chapter queryChapterById(UUID chapterId, String email) {
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

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            for (Question question : questions) {
                question.setPass(checkCodeQuestionIsPassed(
                        user.get().getId().getValue(),
                        question.getId().getValue(),
                        chapterWithQuestions.getCertificateCourseId().getValue()
                        ));
            }
        }

        chapterWithQuestions.setQuestions(questions);

        log.info("Chapter queried with id: {}", chapterId);
        return chapterWithQuestions;
    }

    private Boolean checkCodeQuestionIsPassed(UUID userId, UUID questionId, UUID certificateCourseId) {
        List<CodeSubmission> codeSubmissions = codeSubmissionRepository
                .findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(userId, questionId, certificateCourseId);
        return codeSubmissions.stream()
                .anyMatch(CodeSubmission::getPass);
    }

    private List<ChapterQuestion> getAllChapterQuestionsForChapter(UUID chapterId) {
        List<ChapterQuestion> chapterQuestions = chapterQuestionRepository
                .findAllChapterQuestionsByChapterId(chapterId);

        log.info("All questions queried for chapter with id: {}", chapterId);
        return chapterQuestions;
    }
}





















