package com.backend.programming.learning.system.course.service.dataaccess.question_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper.QuestionSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository.QuestionSubmissionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionSubmissionRepositoryImpl implements QuestionSubmissionRepository {
    private final QuestionSubmissionJpaRepository questionSubmissionJpaRepository;
    private final QuestionSubmissionDataAccessMapper questionSubmissionDataAccessMapper;

    @Override
    public QuestionSubmission save(QuestionSubmission questionSubmission) {
        return questionSubmissionDataAccessMapper
                .questionSubmissionEntityToQuestionSubmission(questionSubmissionJpaRepository
                        .save(questionSubmissionDataAccessMapper
                                .questionSubmissionToQuestionSubmissionEntity(questionSubmission)));
    }

    @Override
    public void saveAll(List<QuestionSubmission> questionSubmissions) {
        questionSubmissions.forEach(this::save);
    }
}
