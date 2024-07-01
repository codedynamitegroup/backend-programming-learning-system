package com.backend.programming.learning.system.course.service.domain.implement.service.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.ExamSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.exception.ExamSubmissionNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.question_submission.QuestionSubmissionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionSubmissionQueryHelper {
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final QuestionSubmissionDataMapper questionSubmissionDataMapper;
    private final ExamSubmissionRepository examSubmissionRepository;

    public List<QuestionSubmission> getQuestionSubmissionByQuestionIdList(QueryQuestionSubmissionCommand queryQuestionSubmissionCommand) {
        ExamSubmission examSubmission = examSubmissionRepository
                .findLatestExamSubmissionByExamIdAndUserId(queryQuestionSubmissionCommand.examId(), queryQuestionSubmissionCommand.userId())
                .orElseThrow(() -> {
                    log.error("Exam submission not found with examId: {} and userId: {}", queryQuestionSubmissionCommand.examId(), queryQuestionSubmissionCommand.userId());

                    return new ExamSubmissionNotFoundException("Exam submission not found");
                });
        if(isExamSubmissionSubmitted(examSubmission)) {
            return List.of();
        }
        return questionSubmissionRepository.findAllByExamSubmissionIdAndQuestionIdList(examSubmission.getId().getValue(), queryQuestionSubmissionCommand.questionSubmissionIds());
    }

    private Boolean isExamSubmissionSubmitted(ExamSubmission examSubmission) {
        // Haven't submit and exam time is not over
        return !Objects.isNull(examSubmission.getSubmitTime()) || !examSubmission.getEndTime()
                .isAfter(ZonedDateTime.now());
    }
}
