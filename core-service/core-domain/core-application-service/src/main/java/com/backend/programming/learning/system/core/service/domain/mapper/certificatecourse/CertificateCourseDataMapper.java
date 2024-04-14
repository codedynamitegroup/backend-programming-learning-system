package com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CertificateCourseDataMapper {
    private final UserRepository userRepository;

    public CertificateCourseDataMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CertificateCourse createCertificateCourseCommandToCertificateCourse(
            CreateCertificateCourseCommand createCertificateCourseCommand) {
        User createdBy = userRepository.findUser(new UserId(createCertificateCourseCommand.getCreatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createCertificateCourseCommand.getCreatedBy()));
        User updatedBy = userRepository.findUser(new UserId(createCertificateCourseCommand.getUpdatedBy()).getValue())
                .orElseThrow(() -> new TopicNotFoundException("User not found with id: " +
                        createCertificateCourseCommand.getUpdatedBy()));
        return CertificateCourse.builder()
                .name(createCertificateCourseCommand.getName())
                .skillLevel(createCertificateCourseCommand.getSkillLevel())
                .avgRating(createCertificateCourseCommand.getAvgRating())
                .startTime(createCertificateCourseCommand.getStartTime())
                .endTime(createCertificateCourseCommand.getEndTime())
                .topics(new ArrayList<>())
                .chapters(new ArrayList<>())
                .reviews(new ArrayList<>())
                .registeredUsers(new ArrayList<>())
                .isDeleted(false)
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .build();
    }

    public CreateCertificateCourseResponse certificateCourseToCreateCertificateCourseResponse(
            CertificateCourse certificateCourse, String message) {
        return CreateCertificateCourseResponse.builder()
                .certificateCourse(certificateCourse)
                .message(message)
                .build();
    }

    public QueryCertificateCourseResponse certificateCourseToQueryCertificateCourseResponse(
            CertificateCourse certificateCourse) {
        return QueryCertificateCourseResponse.builder()
                .certificateCourse(certificateCourse)
                .message("Certificate course found successfully")
                .build();
    }
}
