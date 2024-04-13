package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseTopic;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseUserResponse {
    @NotNull
    private final CertificateCourseUser certificateCourseUser;
    @NotNull
    private final String message;
}
