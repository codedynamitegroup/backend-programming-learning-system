package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.entity.ExamSubmission;
import com.backend.programming.learning.system.valueobject.ExamSubmissionId;
import org.springframework.stereotype.Component;

@Component
public class ExamSubmissionDataAccessMapper {

        public ExamSubmissionEntity examSubmissionToExamSubmissionEntity(ExamSubmission examSubmission) {
            return ExamSubmissionEntity.builder()
                    .id(examSubmission.getId().getValue())
                    .type(examSubmission.getType())
                    .pass_status(examSubmission.getPass_status())
                    .build();
        }

        public ExamSubmission examSubmissionEntityToExamSubmission(ExamSubmissionEntity examSubmissionEntity) {
            return ExamSubmission.builder()
                    .id(new ExamSubmissionId(examSubmissionEntity.getId()))
                    .type(examSubmissionEntity.getType())
                    .pass_status(examSubmissionEntity.getPass_status())
                    .build();
        }
}
