package com.backend.programming.learning.system.mapper.submission_assignment;

import com.backend.programming.learning.system.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.entity.SubmissionAssignment;
import com.backend.programming.learning.system.mapper.user.UserDataMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionAssignmentDataMapper {

    private final UserDataMapper userDataMapper;

    public SubmissionAssignmentDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }
    public SubmissionAssignment createSubmissionAssignmentCommandToSubmissionAssignment(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        return SubmissionAssignment.builder()
                .pass_status(createSubmissionAssignmentCommand.getPass_status())
                .grade(createSubmissionAssignmentCommand.getGrade())
                .content(createSubmissionAssignmentCommand.getContent())
                .submittedAt(createSubmissionAssignmentCommand.getTimeSubmit())
                .build();
    }

    public CreateSubmissionAssignmentResponse submissionAssignmentToCreateSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment,
                                                                                                       String message) {
        return CreateSubmissionAssignmentResponse.builder()
                .assignmentId(submissionAssignment.getAssignment().getId().getValue())
                .userId(submissionAssignment.getUser().getId().getValue())
                .submissionId(submissionAssignment.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentResponseEntity submissionAssignmentToSubmissionAssignmentResponseEntity(SubmissionAssignment submissionAssignment) {
        return SubmissionAssignmentResponseEntity.builder()
                .submissionAssignmentId(submissionAssignment.getId().getValue())
                .userId(submissionAssignment.getUser().getId().getValue())
                .questionId(submissionAssignment.getAssignment().getId().getValue())
                .pass_status(submissionAssignment.getPass_status())
                .grade(submissionAssignment.getGrade())
                .content(submissionAssignment.getContent())
                .submitTime(submissionAssignment.getSubmittedAt())
                .build();
    }

    public QueryAllSubmissionAssignmentResponse submissionAssignmentsToQueryAllSubmissionAssignmentResponse(List<SubmissionAssignment> submissionAssignments) {
        return QueryAllSubmissionAssignmentResponse.builder()
                .submissionAssignments(submissionAssignments.stream()
                        .map(this::submissionAssignmentToSubmissionAssignmentResponseEntity)
                        .toList())
                .build();
    }

    public DeleteSubmissionAssignmentResponse submissionAssignmentToDeleteSubmissionAssignmentResponse(SubmissionAssignment submissionAssignment) {
        return DeleteSubmissionAssignmentResponse.builder()
                .submissionAssignmentId(submissionAssignment.getId().getValue())
                .message("Submission assignment deleted successfully")
                .build();
    }
}
