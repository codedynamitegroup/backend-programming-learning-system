package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseTopicResponse {
    @NotNull
    private final CertificateCourseTopic certificateCourseTopic;
    @NotNull
    private final String message;
}
