package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
import com.backend.programming.learning.system.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.valueobject.AssignmentSubmissionFileId;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSubmissionFileDataAccessMapper {
    public AssignmentSubmissionFileEntity assignmentSubmissionFileToAssignmentSubmissionFileEntity(SubmissionAssignmentFile submissionAssignmentFile) {
        return AssignmentSubmissionFileEntity.builder()
                .id(submissionAssignmentFile.getId().getValue())
                .num_file(submissionAssignmentFile.getNum_file())
                .build();
    }

    public SubmissionAssignmentFile assignmentSubmissionFileEntityToAssignmentSubmissionFile(AssignmentSubmissionFileEntity submissionAssignmentFileEntity) {
        return SubmissionAssignmentFile.builder()
                .id(new AssignmentSubmissionFileId(submissionAssignmentFileEntity.getId()))
                .num_file(submissionAssignmentFileEntity.getNum_file())
                .build();
    }
}
