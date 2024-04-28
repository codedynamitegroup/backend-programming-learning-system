package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_onlinetext;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment_onlinetext.QuerySubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextCommandHandler {
    private final SubmissionAssignmentOnlineTextCreateHelper submissionAssignmentOnlineTextCreateHelper;
    private final SubmissionAssignmentOnlineTextQueryHelper submissionAssignmentOnlineTextQueryHelper;
    private final SubmissionAssignmentOnlineTextDeleteHelper submissionAssignmentOnlineTextDeleteHelper;
    private final SubmissionAssignmentOnlineTextDataMapper submissionAssignmentOnlineTextDataMapper;


    @Transactional
    public CreateSubmissionAssignmentOnlineTextResponse createSubmissionAssignmentOnlineText(
            CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand) {
        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = submissionAssignmentOnlineTextCreateHelper
                .persistSubmissionAssignmentOnlineText(createSubmissionAssignmentOnlineTextCommand);
        return submissionAssignmentOnlineTextDataMapper.
                submissionAssignmentOnlineTextToCreateSubmissionAssignmentOnlineTextResponse(submissionAssignmentOnlineText,
                        "SubmissionAssignmentOnlineText created successfully");

    }

    @Transactional
    public SubmissionAssignmentOnlineTextResponseEntity querySubmissionAssignmentOnlineTextById(QuerySubmissionAssignmentOnlineTextCommand querySubmissionAssignmentOnlineTextCommand) {
        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = submissionAssignmentOnlineTextQueryHelper
                .querySubmissionAssignmentOnlineTextById(querySubmissionAssignmentOnlineTextCommand.getSubmissionAssignmentOnlineTextId());

        return submissionAssignmentOnlineTextDataMapper.submissionAssignmentOnlineTextToSubmissionAssignmentOnlineTextResponseEntity(submissionAssignmentOnlineText);
    }

    @Transactional
    public DeleteSubmissionAssignmentOnlineTextResponse deleteSubmissionAssignmentOnlineTextById(DeleteSubmissionAssignmentOnlineTextCommand deleteSubmissionAssignmentOnlineTextCommand) {
      submissionAssignmentOnlineTextDeleteHelper.deleteSubmissionAssignmentOnlineTextById(deleteSubmissionAssignmentOnlineTextCommand.getSubmissionAssignmentOnlineTextId());
        return DeleteSubmissionAssignmentOnlineTextResponse.builder()
                .submissionAssignmentOnlineTextId(deleteSubmissionAssignmentOnlineTextCommand.getSubmissionAssignmentOnlineTextId())
                .message("SubmissionAssignmentOnlineText deleted successfully")
                .build();

    }

}
