package com.backend.programming.learning.system.course.service.domain.mapper.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import org.springframework.stereotype.Component;

@Component

public class SubmissionGradeDataMapper {

    public SubmissionGradeResponseEntity submissionGradeToSubmissionGradeResponseEntity(SubmissionGrade submissionGrade) {
        return SubmissionGradeResponseEntity.builder()
                .id(submissionGrade.getId().getValue())
                .grade(submissionGrade.getGrade())
                .timeCreated(submissionGrade.getTimeCreated())
                .timeModified(submissionGrade.getTimeModified())
                .build();
    }

}
