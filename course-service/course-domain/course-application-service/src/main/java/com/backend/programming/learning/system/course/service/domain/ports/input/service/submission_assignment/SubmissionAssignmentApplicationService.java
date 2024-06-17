package com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment;

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

import jakarta.validation.Valid;

import java.util.UUID;

public interface SubmissionAssignmentApplicationService {

    CreateSubmissionAssignmentResponse createSubmissionAssignment(@Valid CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand);

    SubmissionAssignmentResponseEntity querySubmissionAssignmentById(@Valid QuerySubmissionAssignmentCommand querySubmissionAssignmentCommand);

    QueryAllSubmissionAssignmentResponse queryAllByAssignmentId(@Valid QueryAllSubmissionnAssignmentCommand queryAllSubmissionnAssignmentCommand);

    DeleteSubmissionAssignmentResponse deleteSubmissionAssignmentById(@Valid DeleteSubmissionAssignmentCommand deleteSubmissionAssignmentCommand);

    UpdateSubmissionAssignmentResponse updateSubmissionAssignmentById(@Valid UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand,UUID id);


    SubmissionAssignmentResponseEntity queryByAssignmentIdAndUserId(QuerySubmissionAssignmentUserCommand querySubmissionAssignmentUserCommand);

    Integer countSubmissionGraded(UUID assignmentId);

    Integer countAllByAssignmentId(UUID assignmentId);
}
