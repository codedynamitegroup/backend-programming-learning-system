package com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.mapper.QuestionSubmissionFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.repository.QuestionSubmissionFileJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmissionFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionFileRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionSubmissionFileRepositoryImpl implements QuestionSubmissionFileRepository {
    private final QuestionSubmissionFileJpaRepository questionSubmissionFileJpaRepository;
    private final QuestionSubmissionFileDataAccessMapper questionSubmissionFileDataAccessMapper;

    public QuestionSubmissionFileRepositoryImpl(QuestionSubmissionFileJpaRepository questionSubmissionFileJpaRepository,
                                                QuestionSubmissionFileDataAccessMapper questionSubmissionFileDataAccessMapper) {
        this.questionSubmissionFileJpaRepository = questionSubmissionFileJpaRepository;
        this.questionSubmissionFileDataAccessMapper = questionSubmissionFileDataAccessMapper;
    }

    @Override
    public Optional<QuestionSubmissionFile> getQuestionSubmissionFile(UUID questionSubmissionFileId) {
        return questionSubmissionFileJpaRepository
                .findById(questionSubmissionFileId)
                .map(questionSubmissionFileDataAccessMapper::questionSubmissionFileEntityToQuestionSubmissionFile);
    }
}
