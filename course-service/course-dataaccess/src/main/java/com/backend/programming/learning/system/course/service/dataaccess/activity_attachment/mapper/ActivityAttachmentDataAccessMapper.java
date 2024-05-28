package com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.entity.ActivityAttachmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_attachment.IntroAttachmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.valueobject.ActivityAttachmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.IntroAttachmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ActivityAttachmentDataAccessMapper {

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;



    public ActivityAttachmentEntity introAttachmentResponseEntityToIntroAttachmentEntity(IntroAttachmentResponseEntity introAttachmentResponseEntity) {
        return ActivityAttachmentEntity.builder()
                .id(introAttachmentResponseEntity.getId())
                .fileName(introAttachmentResponseEntity.getFileName())
                .fileSize(introAttachmentResponseEntity.getFileSize())
                .timemodified(introAttachmentResponseEntity.getTimemodified())
                .mimetype(introAttachmentResponseEntity.getMimetype())
                .fileUrl(introAttachmentResponseEntity.getFileUrl())
                .build();
    }

    public ActivityAttachmentEntity introAttachmentToIntroAttachmentEntity(IntroAttachment introAttachment) {
        return ActivityAttachmentEntity.builder()
                .id(introAttachment.getId().getValue())
                .fileName(introAttachment.getFileName())
                .fileSize(introAttachment.getFileSize())
                .timemodified(introAttachment.getTimemodified())
                .mimetype(introAttachment.getMimetype())
                .fileUrl(introAttachment.getFileUrl())
                .build();
    }

    public ActivityAttachment activityAttachmentEntityToActivityAttachment(ActivityAttachmentEntity activityAttachmentEntity) {
        Assignment assignment = assignmentDataAccessMapper.assignmentEntityToAssignment(activityAttachmentEntity.getAssignment());
        return ActivityAttachment.builder()
                .id(new ActivityAttachmentId(activityAttachmentEntity.getId()))
                .assignment(assignment)
                .fileName(activityAttachmentEntity.getFileName())
                .fileSize(activityAttachmentEntity.getFileSize())
                .timemodified(activityAttachmentEntity.getTimemodified())
                .mimetype(activityAttachmentEntity.getMimetype())
                .fileUrl(activityAttachmentEntity.getFileUrl())
                .build();
    }

    public ActivityAttachmentEntity activityAttachmentToActivityAttachmentEntity(ActivityAttachment activityAttachment) {
        AssignmentEntity assignment = assignmentDataAccessMapper.assignmentToAssignmentEntity(activityAttachment.getAssignment());
        return ActivityAttachmentEntity.builder()
                .id(activityAttachment.getId().getValue())
                .assignment(assignment)
                .fileName(activityAttachment.getFileName())
                .fileSize(activityAttachment.getFileSize())
                .timemodified(activityAttachment.getTimemodified())
                .mimetype(activityAttachment.getMimetype())
                .fileUrl(activityAttachment.getFileUrl())
                .build();
    }

    public List<ActivityAttachment> activityAttachmentEntityListToActivityAttachmentList(List<ActivityAttachmentEntity> allByAssignmentId) {
        return allByAssignmentId.stream().map(this::activityAttachmentEntityToActivityAttachment).toList();
    }
}
