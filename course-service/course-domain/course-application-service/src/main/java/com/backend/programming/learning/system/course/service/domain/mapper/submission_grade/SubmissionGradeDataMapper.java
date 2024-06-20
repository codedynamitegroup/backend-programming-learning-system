package com.backend.programming.learning.system.course.service.domain.mapper.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_grade.SubmissionGradeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment.SubmissionAssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class SubmissionGradeDataMapper {

private final SubmissionAssignmentRepository submissionAssignmentRepository;
    public SubmissionGradeDataMapper( SubmissionAssignmentRepository submissionAssignmentRepository) {
        this.submissionAssignmentRepository = submissionAssignmentRepository;
    }

    public SubmissionGradeResponseEntity submissionGradeToSubmissionGradeResponseEntity(SubmissionGrade submissionGrade) {
        return SubmissionGradeResponseEntity.builder()
                .id(submissionGrade.getId().getValue())
                .grade(submissionGrade.getGrade())
                .timeCreated(submissionGrade.getTimeCreated())
                .timeModified(submissionGrade.getTimeModified())
                .build();
    }

    public SubmissionGrade createSubmissionGradeCommandToSubmissionGrade(CreateSubmissionGradeCommand createSubmissionGradeCommand) {
        Optional<SubmissionAssignment> submissionAssignment = submissionAssignmentRepository.findById(createSubmissionGradeCommand.getSubmissionAssignmentId());
        if (submissionAssignment.isEmpty()) {
            throw new RuntimeException("SubmissionAssignment not found with id: " + createSubmissionGradeCommand.getSubmissionAssignmentId());
        }
        return SubmissionGrade.builder()
                .submissionAssignment(submissionAssignment.get())
                .grade(createSubmissionGradeCommand.getGrade())
                .timeCreated(createSubmissionGradeCommand.getTimeCreated())
                .timeModified(createSubmissionGradeCommand.getTimeModified())
                .build();
    }

    public CreateSubmissionGradeResponse submissionGradeToCreateSubmissionGradeResponse(SubmissionGrade submissionGrade, String submissionGradeCreatedSuccessfully) {
        return CreateSubmissionGradeResponse.builder()
                .id(submissionGrade.getId().getValue())
                .message(submissionGradeCreatedSuccessfully)
                .build();
    }
}
