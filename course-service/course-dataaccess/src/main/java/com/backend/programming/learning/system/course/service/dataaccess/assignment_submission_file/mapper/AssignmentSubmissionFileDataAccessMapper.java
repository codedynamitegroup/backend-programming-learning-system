package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentSubmissionFileId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionAssignmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentSubmissionFileDataAccessMapper {
    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataAccessMapper;

    public AssignmentSubmissionFileEntity assignmentSubmissionFileToAssignmentSubmissionFileEntity(SubmissionAssignmentFile submissionAssignmentFile) {
        SubmissionAssignmentEntity submissionAssignment = submissionAssignmentDataAccessMapper
                .assignmentSubmissionToAssignmentSubmissionEntity(submissionAssignmentFile.getAssignmentSubmission());
        return AssignmentSubmissionFileEntity.builder()
                .id(submissionAssignmentFile.getId().getValue())
                .assignmentSubmission(submissionAssignment)
                .num_file(submissionAssignmentFile.getNum_file())
                .build();
    }

    public SubmissionAssignmentFile assignmentSubmissionFileEntityToAssignmentSubmissionFile(AssignmentSubmissionFileEntity submissionAssignmentFileEntity) {
        SubmissionAssignment submissionAssignment = submissionAssignmentDataAccessMapper
                .assignmentSubmissionEntityToAssignmentSubmission(submissionAssignmentFileEntity.getAssignmentSubmission());
        return SubmissionAssignmentFile.builder()
                .id(new AssignmentSubmissionFileId(submissionAssignmentFileEntity.getId()))
                .assignmentSubmission(submissionAssignment)
                .num_file(submissionAssignmentFileEntity.getNum_file())
                .build();
    }


}
