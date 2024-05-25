package com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.intro_attachment.entity.IntroAttachmentEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.valueobject.IntroAttachmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.IntroFileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntroAttachmentDataAccessMapper {

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;


    public IntroAttachmentResponseEntity introAttachmentEntityToIntroAttachmentResponseEntity(IntroAttachmentEntity introAttachmentEntity) {
        return IntroAttachmentResponseEntity.builder()
                .id(introAttachmentEntity.getId())
                .fileName(introAttachmentEntity.getFileName())
                .fileSize(introAttachmentEntity.getFileSize())
                .timemodified(introAttachmentEntity.getTimemodified())
                .mimetype(introAttachmentEntity.getMimetype())
                .fileUrl(introAttachmentEntity.getFileUrl())
                .build();
    }

    public IntroAttachmentEntity introAttachmentResponseEntityToIntroAttachmentEntity(IntroAttachmentResponseEntity introAttachmentResponseEntity) {
        return IntroAttachmentEntity.builder()
                .id(introAttachmentResponseEntity.getId())
                .fileName(introAttachmentResponseEntity.getFileName())
                .fileSize(introAttachmentResponseEntity.getFileSize())
                .timemodified(introAttachmentResponseEntity.getTimemodified())
                .mimetype(introAttachmentResponseEntity.getMimetype())
                .fileUrl(introAttachmentResponseEntity.getFileUrl())
                .build();
    }

    public List<IntroAttachmentResponseEntity> introAttachmentEntityListToIntroAttachmentResponseEntityList(List<IntroAttachmentEntity> introAttachmentEntityList) {
        return introAttachmentEntityList.stream().map(this::introAttachmentEntityToIntroAttachmentResponseEntity).toList();
    }

    public IntroAttachment introAttachmentEntityToIntroAttachment(IntroAttachmentEntity introAttachmentEntity) {
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(introAttachmentEntity.getAssignment());
        return IntroAttachment.builder()
                .id(new IntroAttachmentId(introAttachmentEntity.getId()))
                .assignment(assignment)
                .fileName(introAttachmentEntity.getFileName())
                .fileSize(introAttachmentEntity.getFileSize())
                .timemodified(introAttachmentEntity.getTimemodified())
                .mimetype(introAttachmentEntity.getMimetype())
                .fileUrl(introAttachmentEntity.getFileUrl())
                .build();
    }

    public IntroAttachmentEntity introAttachmentToIntroAttachmentEntity(IntroAttachment introAttachment) {
        AssignmentEntity assignmentEntity = assignmentDataAccessMapper.assignmentToAssignmentEntity(introAttachment.getAssignment());
        return IntroAttachmentEntity.builder()
                .id(introAttachment.getId().getValue())
                .assignment(assignmentEntity)
                .fileName(introAttachment.getFileName())
                .fileSize(introAttachment.getFileSize())
                .timemodified(introAttachment.getTimemodified())
                .mimetype(introAttachment.getMimetype())
                .fileUrl(introAttachment.getFileUrl())
                .build();
    }
}
