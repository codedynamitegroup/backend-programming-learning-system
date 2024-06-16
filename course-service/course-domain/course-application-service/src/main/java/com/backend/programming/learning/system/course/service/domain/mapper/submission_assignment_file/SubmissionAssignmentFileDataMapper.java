package com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment_file.SubmissionAssignmentFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileDataMapper {


    public SubmissionAssignmentFile createSubmissionAssignmentFileCommandToSubmissionAssignmentFile(CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        return SubmissionAssignmentFile.builder()
                .fileName(createSubmissionAssignmentFileCommand.getFileName())
                .fileSize(createSubmissionAssignmentFileCommand.getFileSize())
                .timemodified(createSubmissionAssignmentFileCommand.getTimemodified())
                .mimetype(createSubmissionAssignmentFileCommand.getMimetype())
                .fileUrl(createSubmissionAssignmentFileCommand.getFileUrl())
                .build();
    }

    public CreateSubmissionAssignmentFileResponse submissionAssignmentFileToCreateSubmissionAssignmentFileResponse(SubmissionAssignmentFile submissionAssignmentFile, String message) {
        return CreateSubmissionAssignmentFileResponse.builder()
                .submissionAssignmentFileId(submissionAssignmentFile.getId().getValue())
                .message(message)
                .build();
    }

    public SubmissionAssignmentFileResponseEntity submissionAssignmentFileToSubmissionAssignmentFileResponseEntity(SubmissionAssignmentFile submissionAssignmentFile) {

        return SubmissionAssignmentFileResponseEntity.builder()
                .id(submissionAssignmentFile.getId().getValue())
                .fileName(submissionAssignmentFile.getFileName())
                .fileSize(submissionAssignmentFile.getFileSize())
                .timemodified(submissionAssignmentFile.getTimemodified())
                .mimetype(submissionAssignmentFile.getMimetype())
                .fileUrl(submissionAssignmentFile.getFileUrl())
                .build();
    }

    public List<SubmissionAssignmentFileResponseEntity> submissionAssignmentFilesToSubmissionAssignmentFileResponseEntities(List<SubmissionAssignmentFile> submissionAssignmentFiles) {
        return submissionAssignmentFiles.stream()
                .map(this::submissionAssignmentFileToSubmissionAssignmentFileResponseEntity)
                .toList();
    }
}
