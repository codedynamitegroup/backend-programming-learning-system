package com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.mapper.ActivityAttachmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.activity_attachment.repository.ActivityAttachmentJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.ActivityAttachment;
import com.backend.programming.learning.system.course.service.domain.entity.IntroAttachment;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ActivityAttachmentRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ActivityAttachmentRepositoryImpl implements ActivityAttachmentRepository {

    private final ActivityAttachmentJpaRepository activityAttachmentJpaRepository;
    private final ActivityAttachmentDataAccessMapper activityAttachmentDataAccessMapper;


    @Override
    public void deleteById(UUID activityAttachmentId) {

    }

    @Override
    public Optional<ActivityAttachment> findById(UUID activityAttachmentId) {
        return activityAttachmentJpaRepository.findById(activityAttachmentId)
                .map(activityAttachmentDataAccessMapper::activityAttachmentEntityToActivityAttachment);
    }

    @Override
    public List<ActivityAttachment> findByAssignmentId(UUID assignmentId) {
        return
                activityAttachmentDataAccessMapper.activityAttachmentEntityListToActivityAttachmentList(activityAttachmentJpaRepository.findAllByAssignmentId(assignmentId));
    }

    @Override
    public ActivityAttachment save(ActivityAttachment activityAttachment) {
        return activityAttachmentDataAccessMapper.activityAttachmentEntityToActivityAttachment(activityAttachmentJpaRepository
                .saveAndFlush(activityAttachmentDataAccessMapper
                        .activityAttachmentToActivityAttachmentEntity(activityAttachment)));
    }
}
