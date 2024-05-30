package com.backend.programming.learning.system.course.service.dataaccess.submission_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.mapper.SubmissionAssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.entity.AssignmentSubmissionFileEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission_file.mapper.AssignmentSubmissionFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.submission_file.entity.SubmissionFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignment;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionAssignmentFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import com.backend.programming.learning.system.course.service.domain.mapper.submission_assignment_file.SubmissionAssignmentFileDataMapper;
import com.backend.programming.learning.system.course.service.domain.valueobject.IntroFileId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionFileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubmissionFileDataAccessMapper {

    private final AssignmentSubmissionFileDataAccessMapper assignmentSubmissionFileDataAccessMapper;


    public SubmissionFile submissionFileEntityToSubmissionFile(SubmissionFileEntity submissionFileEntity) {
        SubmissionAssignmentFile submissionAssignment = assignmentSubmissionFileDataAccessMapper.
                assignmentSubmissionFileEntityToAssignmentSubmissionFile(submissionFileEntity.getSubmissionAssignmentFile());
        return SubmissionFile.builder()
                .id(new SubmissionFileId(submissionFileEntity.getId()))
                .submissionAssignmentFile(submissionAssignment)
                .fileName(submissionFileEntity.getFileName())
                .fileSize(submissionFileEntity.getFileSize())
                .timemodified(submissionFileEntity.getTimemodified())
                .mimetype(submissionFileEntity.getMimetype())
                .fileUrl(submissionFileEntity.getFileUrl())
                .build();

    }

    public SubmissionFileEntity submissionFileToSubmissionFileEntity(SubmissionFile submissionFile) {
        AssignmentSubmissionFileEntity assignmentSubmissionFileEntity = assignmentSubmissionFileDataAccessMapper.
                assignmentSubmissionFileToAssignmentSubmissionFileEntity(submissionFile.getSubmissionAssignmentFile());
        return SubmissionFileEntity.builder()
                .id(submissionFile.getId().getValue())
                .submissionAssignmentFile(assignmentSubmissionFileEntity)
                .fileName(submissionFile.getFileName())
                .fileSize(submissionFile.getFileSize())
                .timemodified(submissionFile.getTimemodified())
                .mimetype(submissionFile.getMimetype())
                .fileUrl(submissionFile.getFileUrl())
                .build();
    }

    public List<SubmissionFile> submissionFileEntityListToSubmissionFileList(List<SubmissionFileEntity> submissionFileEntityList) {
        return submissionFileEntityList.stream().map(this::submissionFileEntityToSubmissionFile).toList();
    }
}
