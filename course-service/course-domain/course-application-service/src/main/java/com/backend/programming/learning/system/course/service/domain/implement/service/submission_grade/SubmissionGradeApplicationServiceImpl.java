package com.backend.programming.learning.system.course.service.domain.implement.service.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_grade.SubmissionGradeApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SubmissionGradeApplicationServiceImpl implements SubmissionGradeApplicationService {
    private final SubmissionGradeCommandHandler submissionGradeCommandHandler;

    @Override
    public CreateSubmissionGradeResponse createSubmissionGrade(CreateSubmissionGradeCommand createSubmissionGradeCommand) {
        return submissionGradeCommandHandler.createSubmissionGrade(createSubmissionGradeCommand);
    }

    @Override
    public UpdateSubmissionGradeResponse updateSubmissionGrade(UpdateSubmissionGradeCommand updateSubmissionGradeCommand, UUID id) {
        return submissionGradeCommandHandler.updateSubmissionGrade(updateSubmissionGradeCommand, id);
    }
}
