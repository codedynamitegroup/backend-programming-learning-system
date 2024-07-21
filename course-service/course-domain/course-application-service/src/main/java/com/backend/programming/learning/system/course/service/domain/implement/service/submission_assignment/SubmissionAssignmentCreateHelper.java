package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleDetailResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionAssignmentCreateHelper {
    private final CourseDomainService coureDomainService;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionAssignmentDataMapper submissionAssignmentDataMapper;
    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;
    private final MoodleCommandHandler moodleCommandHandler;

    @Transactional
    public SubmissionAssignment persistSubmission(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        Assignment assignment= getAssignment(createSubmissionAssignmentCommand.getAssignmentId());
        User user = getUser(createSubmissionAssignmentCommand.getUserId());
        SubmissionAssignment submissionAssignment = submissionAssignmentDataMapper
                .createSubmissionAssignmentCommandToSubmissionAssignment(createSubmissionAssignmentCommand);
        coureDomainService.createSubmissionAssignment(submissionAssignment);
        submissionAssignment.setAssignment(assignment);
        submissionAssignment.setUser(user);
        SubmissionAssignment submissionAssignmentResult = saveSubmission(submissionAssignment);
        return submissionAssignmentResult;
    }

    private SubmissionAssignment saveSubmission(SubmissionAssignment submissionAssignment) {
        SubmissionAssignment savedSubmissionAssignment = submissionAssignmentRepository.saveSubmissionAssignment(submissionAssignment);
        if(savedSubmissionAssignment == null) {
            log.error("AssignmentSubmission is not saved");
            throw new RuntimeException("AssignmentSubmission is not saved");
        }
        log.info("AssignmentSubmission is saved");
        return savedSubmissionAssignment;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private Assignment getAssignment(UUID assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        if (assignment.isEmpty()) {
            log.warn("Assignment with id: {} not found", assignmentId);
            throw new AssignmentNotFoundException("Could not find assignment with id: " + assignmentId);
        }
        return assignment.get();
    }

    @Transactional
    public Boolean createSubmissionAssignment(WebhookMessage webhookMessage, Organization organization) {
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();

        ModuleDetailResponse moduleDetailResponse = moodleCommandHandler.getModuleDetail(webhookMessage.getContextInstanceId(), apiKey, moodleUrl);
        if(moduleDetailResponse.getCm()==null)
            return false;
        Optional<Assignment> assignment = assignmentRepository.findByAssignmentIdMoodle(moduleDetailResponse.getCm().getInstance());

        if(assignment.isEmpty()) {
            log.warn("Assignment with id: {} not found", moduleDetailResponse.getCm().getInstance());
            throw new AssignmentNotFoundException("Could not find assignment with id: " + moduleDetailResponse.getCm().getInstance());
        }

        moodleCommandHandler.createSubmissionAssignment(assignment.get(), webhookMessage.getUserId(),apiKey, moodleUrl);
        return true;
    }
}
