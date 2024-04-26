package com.backend.programming.learning.system.course.service.domain.implement.submission_assignment_onlinetext;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext.QuerySubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextApplicationServiceImpl implements SubmissionAssignmentOnlineTextApplicationService {
    private final SubmissionAssignmentOnlineTextCommandHandler submissionAssignmentOnlineTextCommandHandler;
    @Override
    public CreateSubmissionAssignmentOnlineTextResponse createSubmissionAssignmentOnlineText(CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand) {
        return submissionAssignmentOnlineTextCommandHandler.createSubmissionAssignmentOnlineText(createSubmissionAssignmentOnlineTextCommand);
    }

    @Override
    public SubmissionAssignmentOnlineTextResponseEntity querySubmissionAssignmentOnlineTextById(QuerySubmissionAssignmentOnlineTextCommand querySubmissionAssignmentOnlineTextCommand) {
        return submissionAssignmentOnlineTextCommandHandler.querySubmissionAssignmentOnlineTextById(querySubmissionAssignmentOnlineTextCommand);
    }

    @Override
    public DeleteSubmissionAssignmentOnlineTextResponse deleteSubmissionAssignmentOnlineTextById(DeleteSubmissionAssignmentOnlineTextCommand deleteSubmissionAssignmentOnlineTextCommand) {
        return submissionAssignmentOnlineTextCommandHandler.deleteSubmissionAssignmentOnlineTextById(deleteSubmissionAssignmentOnlineTextCommand);
    }
}
