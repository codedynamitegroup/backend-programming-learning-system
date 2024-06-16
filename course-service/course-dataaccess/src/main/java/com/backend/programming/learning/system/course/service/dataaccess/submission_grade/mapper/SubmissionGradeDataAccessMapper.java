package com.backend.programming.learning.system.course.service.dataaccess.submission_grade.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.submission_grade.entity.SubmissionGradeEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionGradeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionGradeDataAccessMapper {
    private final SubmissionAssignmentDataAccessMapper submissionAssignmentDataMapper;
    public SubmissionGrade submissionGradeEntityToSubmissionGrade(SubmissionGradeEntity submissionGradeEntity) {
        SubmissionAssignment submissionAssignment = submissionAssignmentDataMapper.submissionAssignmentEntityToSubmissionAssignment(submissionGradeEntity.getSubmissionAssignment());
        return SubmissionGrade.builder()
                .id(new SubmissionGradeId(submissionGradeEntity.getId()))
                .submissionAssignment(submissionAssignment)
                .grade(submissionGradeEntity.getGrade())
                .timeCreated(submissionGradeEntity.getTimeCreated())
                .timeModified(submissionGradeEntity.getTimeModified())
                .build();
    }

    public SubmissionGradeEntity submissionGradeToSubmissionGradeEntity(SubmissionGrade submissionGrade) {
        SubmissionAssignmentEntity submissionAssignmentEntity = submissionAssignmentDataMapper.
                assignmentSubmissionToAssignmentSubmissionEntity(submissionGrade.getSubmissionAssignment());
        return SubmissionGradeEntity.builder()
                .id(submissionGrade.getId().getValue())
                .submissionAssignment(submissionAssignmentEntity)
                .grade(submissionGrade.getGrade())
                .timeCreated(submissionGrade.getTimeCreated())
                .timeModified(submissionGrade.getTimeModified())
                .build();
    }
}
