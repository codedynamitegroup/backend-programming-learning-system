package com.backend.programming.learning.system.course.service.domain.implement.service.submission_grade;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_grade.SubmissionGradeDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionAssignmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionGradeCreateHelper {
    private final CourseDomainService coureDomainService;
    private final SubmissionGradeRepository submissionGradeRepository;
    private final SubmissionGradeDataMapper submissionGradeDataMapper;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;

    @Transactional
    public SubmissionGrade persistSubmissionGrade(CreateSubmissionGradeCommand createSubmissionGradeCommand) {
        SubmissionGrade submissionGrade = submissionGradeDataMapper.createSubmissionGradeCommandToSubmissionGrade(createSubmissionGradeCommand);
        coureDomainService.createSubmissionGrade(submissionGrade);
       SubmissionGrade submissionGradeResult= saveSubmissionGrade(submissionGrade);
        return submissionGradeResult;
    }

    private SubmissionGrade saveSubmissionGrade(SubmissionGrade submissionGrade) {
        SubmissionGrade savedSubmissionGrade = submissionGradeRepository.save(submissionGrade);
        if(savedSubmissionGrade == null) {
            log.error("SubmissionGrade is not saved");
            throw new RuntimeException("SubmissionGrade is not saved");
        }
        log.info("SubmissionGrade is saved");
        return savedSubmissionGrade;
    }
}
