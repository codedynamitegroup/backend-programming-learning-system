package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.AIGradeEssayScheduler;

import com.backend.programming.learning.system.course.service.domain.entity.AssignmentAIGradeReport;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.ai_grade_essay.AIGradeEssayApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentAIGradeReportRepository;
import com.backend.programming.learning.system.domain.valueobject.AssignmentAIGradeReportStatus;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Component
public class AIGradeEssayScheduler {
    private final AssignmentAIGradeReportRepository assignmentAIGradeReportRepository;
    private final AIGradeEssayApplicationService aiGradeEssayApplicationService;

    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        List<AssignmentAIGradeReport> assignmentAIGradeReports =
                assignmentAIGradeReportRepository.findByStatus(AssignmentAIGradeReportStatus.PENDING);
        if (!assignmentAIGradeReports.isEmpty()) {
            log.info("Received {} AssignmentAIGradeReport with ids {}, sending to AI for grading!",
                    assignmentAIGradeReports.size(),
                    assignmentAIGradeReports.stream().map(assignmentAIGradeReport ->
                            assignmentAIGradeReport.getId().toString()).collect(Collectors.joining(",")));
            assignmentAIGradeReports.forEach(assignmentAIGradeReport -> {
                try {
                    aiGradeEssayApplicationService.gradeEssay(assignmentAIGradeReport);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
            log.info("{} AssignmentAIGradeReport sent to AI for grading!", assignmentAIGradeReports.size());
        }
    }
}
