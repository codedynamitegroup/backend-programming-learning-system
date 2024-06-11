package com.backend.programming.learning.system.course.service.dataaccess.question_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper.QuestionSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository.QuestionSubmissionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    @Override
    public List<QuestionSubmission> findAllByExamSubmissionId(UUID submissionId) {
        return questionSubmissionDataAccessMapper
                .questionSubmissionEntityListToQuestionSubmissionList(
                        questionSubmissionJpaRepository.findByExamSubmissionId(submissionId));
    }

    @Override
    public void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList) {
        List<QuestionSubmissionEntity> questionSubmissionEntities = new ArrayList<>();
        markQuestionSubmissionCommandList.forEach(markQuestionSubmissionCommand -> {
                    QuestionSubmissionEntity entity = questionSubmissionJpaRepository.findByExamSubmissionIdAndQuestionId(
                            markQuestionSubmissionCommand.examSubmissionId(),
                            markQuestionSubmissionCommand.questionId()
                    ).orElse(null);
                    if (Objects.nonNull(entity)) {
                        entity.setGrade(markQuestionSubmissionCommand.grade());
                        entity.setRightAnswer(markQuestionSubmissionCommand.rightAnswer());
                    }
                    questionSubmissionEntities.add(entity);
                });
        questionSubmissionJpaRepository.saveAll(questionSubmissionEntities);
    }

}
