package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.SubmissionAssignmentFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentSubmissionFileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionAssignmentFileDataAccessMapper {
    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper;

    public SubmissionAssignmentFileEntity assignmentSubmissionFileToAssignmentSubmissionFileEntity(SubmissionAssignmentFile submissionAssignmentFile) {
        SubmissionAssignmentEntity submissionAssignment = submissionAssignmentDataAccessMapper
                .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignmentFile.getAssignmentSubmission());
        return SubmissionAssignmentFileEntity.builder()
                .id(submissionAssignmentFile.getId().getValue())
                .submissionAssignment(submissionAssignment)
                .fileName(submissionAssignmentFile.getFileName())
                .fileSize(submissionAssignmentFile.getFileSize())
                .fileUrl(submissionAssignmentFile.getFileUrl())
                .mimetype(submissionAssignmentFile.getMimetype())
                .timemodified(submissionAssignmentFile.getTimemodified())
                .build();
    }

    public SubmissionAssignmentFile assignmentSubmissionFileEntityToAssignmentSubmissionFile(SubmissionAssignmentFileEntity submissionAssignmentFileEntity) {
        SubmissionAssignment submissionAssignment = submissionAssignmentDataAccessMapper
                .assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentFileEntity.getSubmissionAssignment());
        return SubmissionAssignmentFile.builder()
                .id(new AssignmentSubmissionFileId(submissionAssignmentFileEntity.getId()))
                .assignmentSubmission(submissionAssignment)
                .fileUrl(submissionAssignmentFileEntity.getFileUrl())
                .mimetype(submissionAssignmentFileEntity.getMimetype())
                .fileName(submissionAssignmentFileEntity.getFileName())
                .fileSize(submissionAssignmentFileEntity.getFileSize())
                .timemodified(submissionAssignmentFileEntity.getTimemodified())
                .build();
    }


}
