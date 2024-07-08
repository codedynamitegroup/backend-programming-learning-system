package com.backend.programming.learning.system.course.service.dataaccess.question_submission.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper.QuestionSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository.QuestionSubmissionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

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
        if(questionSubmissions.isEmpty()) {
            return;
        }

        List<QuestionSubmissionEntity> entities = questionSubmissions.stream()
                .map(questionSubmissionDataAccessMapper::questionSubmissionToQuestionSubmissionEntity)
                .collect(Collectors.toList());
        questionSubmissionJpaRepository.saveAll(entities);
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
                        entity.setFeedback(markQuestionSubmissionCommand.feedback());
                    }
                    questionSubmissionEntities.add(entity);
                });
        questionSubmissionJpaRepository.saveAll(questionSubmissionEntities);
    }

    @Override
    public List<QuestionSubmission> findByExamIdAndUserId(ExamId examId, UserId userId) {
        return questionSubmissionDataAccessMapper
                .questionSubmissionEntityListToQuestionSubmissionList(
                        questionSubmissionJpaRepository
                                .findByExamIdAndUserId(examId.getValue(), userId.getValue()));
    }

    @Override
    public Optional<QuestionSubmission> findByExamSubmissionIdAndQuestionId(UUID examSubmissionId, UUID questionId) {
        return questionSubmissionJpaRepository.findByExamSubmissionIdAndQuestionId(examSubmissionId, questionId)
                .map(questionSubmissionDataAccessMapper::questionSubmissionEntityToQuestionSubmission);
    }

    @Override
    public List<QuestionSubmission> findAllByExamSubmissionIdAndQuestionIdList(
            UUID examSubmissionId,
            List<UUID> questionId) {
        return questionSubmissionJpaRepository.findAllByExamSubmissionIdAndQuestionIdList(examSubmissionId, questionId)
                .stream()
                .map(questionSubmissionDataAccessMapper::questionSubmissionEntityToQuestionSubmission)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionSubmission> findById(UUID value) {
        return questionSubmissionJpaRepository
                .findById(value)
                .map(questionSubmissionDataAccessMapper::questionSubmissionEntityToQuestionSubmission);
    }
}
