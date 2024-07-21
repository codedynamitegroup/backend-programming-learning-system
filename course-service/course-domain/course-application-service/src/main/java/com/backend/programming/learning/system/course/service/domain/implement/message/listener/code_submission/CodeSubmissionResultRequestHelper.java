package com.backend.programming.learning.system.course.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeSubmissionResultRequest;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.CodeSubmissionResultOutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionResultRequestHelper {
    private final CodeSubmissionResultOutboxRepository codeSubmissionResultOutboxRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final ExamSubmissionRepository examSubmissionRepository;

    @Transactional
    public QuestionSubmission handleCodeSubmissionResultRequest(CodeSubmissionResultRequest request) {
        if(request.getGrade() == null)
            return null;

        //save for opt lock
        Optional<UUID> outboxId = codeSubmissionResultOutboxRepository.findBySagaId(request.getSagaId());
        if(outboxId.isPresent()){
            log.info("code submission with sagaId {} was processed", request.getSagaId());
            return null;
        }
        codeSubmissionResultOutboxRepository.save(UUID.randomUUID(), request.getSagaId());

        Optional<QuestionSubmission> questionSubmissionOpt = questionSubmissionRepository.findById(request.getCodeSubmissionId());
        if(questionSubmissionOpt.isPresent()){
            QuestionSubmission questionSubmission = questionSubmissionOpt.get();
            questionSubmission.setGrade(request.getGrade());
            questionSubmission.setRightAnswer(request.getResult());
            questionSubmissionRepository.save(questionSubmission);
            return questionSubmission;
        }
        return null;
    }

    @Transactional
    public void updateExamSubmissionScore(QuestionSubmission questionSubmission) {
        if(questionSubmission.getGrade() != null)
            examSubmissionRepository.updateExamSubmissionScore(questionSubmission.getExamSubmission().getId(), questionSubmission.getGrade());
    }
}
