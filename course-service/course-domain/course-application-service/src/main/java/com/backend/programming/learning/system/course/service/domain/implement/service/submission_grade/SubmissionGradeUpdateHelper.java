package com.backend.programming.learning.system.course.service.domain.implement.service.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionGrade;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionGradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionGradeUpdateHelper {
    private final SubmissionGradeRepository submissionGradeRepository;

    @Transactional
    public void updateSubmissionGrade(UpdateSubmissionGradeCommand updateSubmissionGradeCommand, UUID id) {
        SubmissionGrade submissionGrade = getSubmissionGrade(id);
        if(updateSubmissionGradeCommand.getGrade()!=null) {
            submissionGrade.setGrade(updateSubmissionGradeCommand.getGrade());
        }
        if(updateSubmissionGradeCommand.getTimemodified()!=null) {
            submissionGrade.setTimeModified(updateSubmissionGradeCommand.getTimemodified());
        }
        submissionGradeRepository.save(submissionGrade);
    }


    public SubmissionGrade getSubmissionGrade(UUID id) {
        return submissionGradeRepository.findById(id).get();
    }
}
