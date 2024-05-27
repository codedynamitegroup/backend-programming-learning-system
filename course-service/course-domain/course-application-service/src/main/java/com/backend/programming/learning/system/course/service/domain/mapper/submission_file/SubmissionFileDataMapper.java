package com.backend.programming.learning.system.course.service.domain.mapper.submission_file;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_file.SubmissionFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmissionFileDataMapper {
    public SubmissionFileResponseEntity SubmissionFileToSubmissionFileResponseEntity(SubmissionFile SubmissionFile) {
        return SubmissionFileResponseEntity.builder()
                .id(SubmissionFile.getId().getValue())
                .fileName(SubmissionFile.getFileName())
                .fileSize(SubmissionFile.getFileSize())
                .timemodified(SubmissionFile.getTimemodified())
                .mimetype(SubmissionFile.getMimetype())
                .fileUrl(SubmissionFile.getFileUrl())
                .build();
    }

    public SubmissionFileResponseEntity submissionFileToSubmissionFileResponseEntity(SubmissionFile submissionFile) {
        return SubmissionFileResponseEntity.builder()
                .id(submissionFile.getId().getValue())
                .fileName(submissionFile.getFileName())
                .fileSize(submissionFile.getFileSize())
                .timemodified(submissionFile.getTimemodified())
                .mimetype(submissionFile.getMimetype())
                .fileUrl(submissionFile.getFileUrl())
                .build();
    }

    public List<SubmissionFileResponseEntity> submissionFileListToSubmissionFileResponseEntityList(List<SubmissionFile> submissionFileList) {
        return submissionFileList.stream().map(this::submissionFileToSubmissionFileResponseEntity).toList();
    }
}
