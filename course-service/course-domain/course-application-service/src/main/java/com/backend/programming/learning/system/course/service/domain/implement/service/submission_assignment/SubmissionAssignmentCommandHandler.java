package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QuerySubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QuerySubmissionAssignmentUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentCommandHandler {
    private final SubmissionAssignmentCreateHelper submissionAssignmentCreateHelper;
    private final SubmissionAssignmentQueryHelper submissionAssignmentQueryHelper;
    private final SubmissionAssignmentDeleteHelper submissionAssignmentDeleteHelper;
    private final SubmissionAssignmentUpdateHelper submissionAssignmentUpdateHelper;
    private final SubmissionAssignmentDataMapper submissionAssignmentDataMapper;

    @Transactional
    public CreateSubmissionAssignmentResponse createSubmissionAssignment(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        log.info("Create submission assignment command received");
        SubmissionAssignment submissionAssignment = submissionAssignmentCreateHelper.persistSubmission(createSubmissionAssignmentCommand);
        return submissionAssignmentDataMapper.submissionAssignmentToCreateSubmissionAssignmentResponse(submissionAssignment, "Submission assignment created successfully");
    }

    @Transactional
    public SubmissionAssignmentResponseEntity querySubmissionAssignmentById(QuerySubmissionAssignmentCommand querySubmissionAssignmentCommand) {
        log.info("Query submission assignment by id command received");
        SubmissionAssignment submissionAssignment = submissionAssignmentQueryHelper.querySubmissionAssignmentById(querySubmissionAssignmentCommand.getSubmissionId());
        return submissionAssignmentDataMapper.submissionAssignmentToSubmissionAssignmentResponseEntity(submissionAssignment);
    }

    @Transactional
    public QueryAllSubmissionAssignmentResponse queryAllByAssignmentId(QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand) {
        log.info("Query all submission assignment by assignment id command received");
        return submissionAssignmentDataMapper
                .submissionAssignmentsToQueryAllSubmissionAssignmentResponse(submissionAssignmentQueryHelper
                        .queryAllByAssignmentId(new QueryAllSubmissionnAssignmentCommand(queryAllSubmissionnAssignmentCommand
                                .getAssignmentId())));
    }

    @Transactional
    public DeleteSubmissionAssignmentResponse deleteSubmissionAssignmentById(DeleteSubmissionAssignmentCommand deleteSubmissionAssignmentCommand) {
        log.info("Delete submission assignment by id command received");
        submissionAssignmentDeleteHelper.deleteSubmissionAssignmentById(deleteSubmissionAssignmentCommand.getSubmissionAssignmentId());
        return DeleteSubmissionAssignmentResponse.builder()
                .submissionAssignmentId(deleteSubmissionAssignmentCommand.getSubmissionAssignmentId())
                .message("Submission assignment deleted successfully")
                .build();

    }

    @Transactional
    public UpdateSubmissionAssignmentResponse updateSubmissionAssignment(UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand) {
        log.info("Update submission assignment command received");
        submissionAssignmentUpdateHelper.persistSubmissionAssignment(updateSubmissionAssignmentCommand);
        return UpdateSubmissionAssignmentResponse.builder()
                .submissionId(updateSubmissionAssignmentCommand.getSubmissionAssignmentId())
                .message("Submission assignment updated successfully")
                .build();
    }

    @Transactional
    public SubmissionAssignmentResponseEntity queryByAssignmentIdAndUserId(QuerySubmissionAssignmentUserCommand querySubmissionAssignmentUserCommand) {
        log.info("Query submission assignment by assignment id and user id command received");
        SubmissionAssignment submissionAssignment = submissionAssignmentQueryHelper.queryByAssignmentIdAndUserId(querySubmissionAssignmentUserCommand.getAssignmentId(), querySubmissionAssignmentUserCommand.getUserId());
        return submissionAssignmentDataMapper.submissionAssignmentToSubmissionAssignmentResponseEntity(submissionAssignment);
    }






}
