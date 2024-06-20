package com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface SubmissionGradeApplicationService {

    CreateSubmissionGradeResponse createSubmissionGrade(@Valid CreateSubmissionGradeCommand createSubmissionGradeCommand);

    UpdateSubmissionGradeResponse updateSubmissionGrade(@Valid UpdateSubmissionGradeCommand updateSubmissionGradeCommand, UUID id);
}
