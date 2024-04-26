package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileDataMapper {

    public SubmissionAssignmentFile createSubmissionAssignmentFileCommandToSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        return SubmissionAssignmentFile.builder()
                .num_file(createSubmissionAssignmentFileCommand.getNum_file())
                .build();
    }

    public CreateSubmissionAssignmentFileResponse submissionAssignmentFileToCreateSubmissionAssignmentFileResponse(SubmissionAssignmentFile submissionAssignmentFile, String message) {
        return CreateSubmissionAssignmentFileResponse.builder()
                .submissionAssignmentFileId(submissionAssignmentFile.getId().getValue())
                .message(message)
                .build();
    }
}
