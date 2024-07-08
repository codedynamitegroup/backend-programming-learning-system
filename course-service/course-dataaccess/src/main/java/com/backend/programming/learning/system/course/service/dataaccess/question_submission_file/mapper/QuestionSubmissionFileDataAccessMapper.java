package com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.mapper.QuestionSubmissionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.entity.QuestionSubmissionFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmissionFile;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionSubmissionFileId;
import org.springframework.stereotype.Component;

@Component
public class QuestionSubmissionFileDataAccessMapper {
    private final QuestionSubmissionDataAccessMapper questionSubmissionDataAccessMapper;

    public QuestionSubmissionFileDataAccessMapper(QuestionSubmissionDataAccessMapper questionSubmissionDataAccessMapper) {
        this.questionSubmissionDataAccessMapper = questionSubmissionDataAccessMapper;
    }

    public QuestionSubmissionFileEntity questionSubmissionFileToQuestionSubmissionFileEntity(QuestionSubmissionFile questionSubmissionFile) {
        return QuestionSubmissionFileEntity
                .builder()
                .id(questionSubmissionFile.getId().getValue())
                .url(questionSubmissionFile.getUrl())
                .name(questionSubmissionFile.getName())
                .type(questionSubmissionFile.getType())
                .fileSize(questionSubmissionFile.getSize())
                .questionSubmission(questionSubmissionDataAccessMapper
                        .questionSubmissionToQuestionSubmissionEntity(questionSubmissionFile.getQuestionSubmission()))
                .build();
    }

    public QuestionSubmissionFile questionSubmissionFileEntityToQuestionSubmissionFile(QuestionSubmissionFileEntity questionSubmissionFileEntity) {
        return QuestionSubmissionFile
                .builder()
                .id(new QuestionSubmissionFileId(questionSubmissionFileEntity.getId()))
                .url(questionSubmissionFileEntity.getUrl())
                .name(questionSubmissionFileEntity.getName())
                .type(questionSubmissionFileEntity.getType())
                .size(questionSubmissionFileEntity.getFileSize())
                .questionSubmission(questionSubmissionDataAccessMapper
                        .questionSubmissionEntityToQuestionSubmission(questionSubmissionFileEntity.getQuestionSubmission()))
                .build();
    }
}
