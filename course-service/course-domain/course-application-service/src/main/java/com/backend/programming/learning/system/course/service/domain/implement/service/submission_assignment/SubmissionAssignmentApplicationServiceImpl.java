package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.AllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment.SubmissionAssignmentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentApplicationServiceImpl implements SubmissionAssignmentApplicationService {

    private final SubmissionAssignmentCommandHandler submissionAssignmentCommandHandler;
    @Override
    public CreateSubmissionAssignmentResponse createSubmissionAssignment(CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand) {
        return submissionAssignmentCommandHandler.createSubmissionAssignment(createSubmissionAssignmentCommand);
    }

    @Override
    public AllSubmissionAssignmentResponse querySubmissionAssignmentById(QuerySubmissionAssignmentCommand querySubmissionAssignmentCommand) {
        return submissionAssignmentCommandHandler.querySubmissionAssignmentById(querySubmissionAssignmentCommand);
    }

    @Override
    public QueryAllSubmissionAssignmentResponse queryAllByAssignmentId(QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand) {
        return submissionAssignmentCommandHandler.queryAllByAssignmentId(queryAllSubmissionnAssignmentCommand);
    }

    @Override
    public DeleteSubmissionAssignmentResponse deleteSubmissionAssignmentById(DeleteSubmissionAssignmentCommand deleteSubmissionAssignmentCommand) {
        return submissionAssignmentCommandHandler.deleteSubmissionAssignmentById(deleteSubmissionAssignmentCommand);
    }

    @Override
    public UpdateSubmissionAssignmentResponse updateSubmissionAssignmentById(UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand,UUID id) {
        return submissionAssignmentCommandHandler.updateSubmissionAssignment(updateSubmissionAssignmentCommand,id);
    }

    @Override
    public AllSubmissionAssignmentResponse queryByAssignmentIdAndUserId(QuerySubmissionAssignmentUserCommand querySubmissionAssignmentCommand) {
        return submissionAssignmentCommandHandler.queryByAssignmentIdAndUserId(querySubmissionAssignmentCommand);
    }

    @Override
    public Integer countSubmissionGraded(UUID assignmentId) {
        return submissionAssignmentCommandHandler.countSubmissionGraded(assignmentId);
    }

    @Override
    public Integer countAllByAssignmentId(UUID assignmentId) {
        return submissionAssignmentCommandHandler.countAllByAssignmentId(assignmentId);
    }

    @Override
    public QueryAllUserSubmissionAssignmentResponse queryAllSubmissionAssignment(QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand) {
        return
                submissionAssignmentCommandHandler.queryAllSubmissionAssignment(queryAllSubmissionnAssignmentCommand);
    }
}
