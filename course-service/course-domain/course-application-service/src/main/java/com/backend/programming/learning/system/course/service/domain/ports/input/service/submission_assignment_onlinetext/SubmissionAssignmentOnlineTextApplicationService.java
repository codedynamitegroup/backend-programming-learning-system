package com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_onlinetext;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext.QuerySubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;

import jakarta.validation.Valid;

public interface SubmissionAssignmentOnlineTextApplicationService {
    CreateSubmissionAssignmentOnlineTextResponse createSubmissionAssignmentOnlineText(@Valid CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand);

    SubmissionAssignmentOnlineTextResponseEntity querySubmissionAssignmentOnlineTextById(@Valid QuerySubmissionAssignmentOnlineTextCommand querySubmissionAssignmentOnlineTextCommand);

    DeleteSubmissionAssignmentOnlineTextResponse deleteSubmissionAssignmentOnlineTextById(@Valid DeleteSubmissionAssignmentOnlineTextCommand deleteSubmissionAssignmentOnlineTextCommand);
}
