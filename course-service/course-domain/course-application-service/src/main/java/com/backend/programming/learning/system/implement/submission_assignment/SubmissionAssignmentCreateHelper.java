package com.backend.programming.learning.system.implement.submission_assignment;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.entity.Assignment;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.exception.AssignmentNotFoundException;
import com.backend.programming.learning.system.exception.UserNotFoundException;
import com.backend.programming.learning.system.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
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
}
