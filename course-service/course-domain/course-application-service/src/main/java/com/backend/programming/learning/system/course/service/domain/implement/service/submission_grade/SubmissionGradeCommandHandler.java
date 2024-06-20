package com.backend.programming.learning.system.course.service.domain.implement.service.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_grade.SubmissionGradeDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SubmissionGradeCommandHandler {
    private final SubmissionGradeCreateHelper submissionGradeCreateHelper;
    private final SubmissionGradeUpdateHelper submissionGradeUpdateHelper;
    private final SubmissionGradeDataMapper submissionGradeDataMapper;

    @Transactional
    CreateSubmissionGradeResponse createSubmissionGrade(CreateSubmissionGradeCommand createSubmissionGradeCommand) {
        log.info("Create submission grade command received");
        SubmissionGrade submissionGrade = submissionGradeCreateHelper.persistSubmissionGrade(createSubmissionGradeCommand);
        return submissionGradeDataMapper.submissionGradeToCreateSubmissionGradeResponse(submissionGrade, "Submission grade created successfully");
    }

    @Transactional
    UpdateSubmissionGradeResponse updateSubmissionGrade(UpdateSubmissionGradeCommand updateSubmissionGradeCommand, UUID id) {
        log.info("Update submission grade command received");
       submissionGradeUpdateHelper.updateSubmissionGrade(updateSubmissionGradeCommand,id);
        return UpdateSubmissionGradeResponse.builder()
                .id(id)
                .message("Submission grade updated successfully")
                .build();
    }
}
