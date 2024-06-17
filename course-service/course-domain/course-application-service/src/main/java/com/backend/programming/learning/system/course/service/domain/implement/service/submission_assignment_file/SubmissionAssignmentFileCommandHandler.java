package com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment.SubmissionAssignmentUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SubmissionAssignmentFileCommandHandler {
    private final SubmissionAssignmentFileCreateHelper submissionAssignmentFileCreateHelper;
    private final SubmissionAssignmentFileUpdateHelper submissionAssignmentFileUpdateHelper;
    private final SubmissionAssignmentFileDeleteHelper submissionAssignmentFileDeleteHelper;
    private final SubmissionAssignmentFileDataMapper submissionAssignmentFileDataMapper;

    @Transactional
    public CreateSubmissionAssignmentFileResponse createSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        SubmissionAssignmentFile submissionAssignmentFile = submissionAssignmentFileCreateHelper
                .persistSubmissionAssignmentFile(createSubmissionAssignmentFileCommand);
        return submissionAssignmentFileDataMapper
                .submissionAssignmentFileToCreateSubmissionAssignmentFileResponse(submissionAssignmentFile,
                        "SubmissionAssignmentFile created successfully");

    }

    @Transactional
    public UpdateSubmissionAssignmentFileResponse updateSubmissionAssignmentFile(UpdateSubmissionAssignmentFileCommand updateSubmissionAssignmentFileCommand, UUID id) {
        submissionAssignmentFileUpdateHelper.persistSubmissionAssignmentFile(updateSubmissionAssignmentFileCommand, id);
        return UpdateSubmissionAssignmentFileResponse.builder()
                .id(id)
                .message("SubmissionAssignmentFile updated successfully")
                .build();
    }

    @Transactional
    public DeleteSubmissionAssignmentFileResponse deleteSubmissionAssignmentFile(UUID submissionAssignmentFileId) {
        submissionAssignmentFileDeleteHelper.deleteSubmissionAssignmentFileById(submissionAssignmentFileId);
        return DeleteSubmissionAssignmentFileResponse.builder()
                .message("SubmissionAssignmentFile deleted successfully")
                .build();
    }
}
