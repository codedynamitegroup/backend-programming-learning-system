package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_onlinetext;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_onlinetext.DeleteSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_onlinetext.SubmissionAssignmentOnlineTextResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentOnlineText;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentOnlineTextDataMapper {

    public SubmissionAssignmentOnlineText createSubmissionAssignmentOnlineTextCommandToSubmissionAssignmentOnlineText(CreateSubmissionAssignmentOnlineTextCommand createSubmissionAssignmentOnlineTextCommand) {
        return SubmissionAssignmentOnlineText.builder()
                .content(createSubmissionAssignmentOnlineTextCommand.getContent())
                .build();
    }

    public CreateSubmissionAssignmentOnlineTextResponse submissionAssignmentOnlineTextToCreateSubmissionAssignmentOnlineTextResponse(SubmissionAssignmentOnlineText submissionAssignmentOnlineText, String message) {
        return CreateSubmissionAssignmentOnlineTextResponse.builder()
                .submissionAssignmentOnlineTextId(submissionAssignmentOnlineText.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentOnlineTextResponseEntity submissionAssignmentOnlineTextToSubmissionAssignmentOnlineTextResponseEntity(SubmissionAssignmentOnlineText submissionAssignmentOnlineText) {
        return SubmissionAssignmentOnlineTextResponseEntity.builder()
                .id(submissionAssignmentOnlineText.getId().getValue())
                .content(submissionAssignmentOnlineText.getContent())
                .build();
    }

    public DeleteSubmissionAssignmentOnlineTextResponse submissionAssignmentOnlineTextIdToDeleteSubmissionAssignmentOnlineTextResponse(SubmissionAssignmentOnlineText submissionAssignmentOnlineText, String message) {
        return DeleteSubmissionAssignmentOnlineTextResponse.builder()
                .submissionAssignmentOnlineTextId(submissionAssignmentOnlineText.getId().getValue())
                .message(message)
                .build();
    }

}
