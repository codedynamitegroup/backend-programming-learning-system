package com.backend.programming.learning.system.course.service.dataaccess.question_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper.QuestionSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository.QuestionSubmissionJpaRepository;
import com.backend.programming.learning.system.entity.QuestionSubmission;
import com.backend.programming.learning.system.ports.output.repository.QuestionSubmissionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionSubmissionRepositoryImpl implements QuestionSubmissionRepository {
    private final QuestionSubmissionJpaRepository questionSubmissionJpaRepository;
    private final QuestionSubmissionDataAccessMapper questionSubmissionDataAccessMapper;

    public QuestionSubmissionRepositoryImpl(QuestionSubmissionJpaRepository questionSubmissionJpaRepository, QuestionSubmissionDataAccessMapper questionSubmissionDataAccessMapper) {
        this.questionSubmissionJpaRepository = questionSubmissionJpaRepository;
        this.questionSubmissionDataAccessMapper = questionSubmissionDataAccessMapper;
    }


    @Override
    public QuestionSubmission saveQuestionSubmission(QuestionSubmission questionSubmission) {
        return questionSubmissionDataAccessMapper
                .questionSubmissionEntityToQuestionSubmission(questionSubmissionJpaRepository
                        .save(questionSubmissionDataAccessMapper
                                .questionSubmissionToQuestionSubmissionEntity(questionSubmission)));
    }
}
