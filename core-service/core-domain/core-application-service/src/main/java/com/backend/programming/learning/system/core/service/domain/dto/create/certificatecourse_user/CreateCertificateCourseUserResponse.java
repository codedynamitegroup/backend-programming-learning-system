package com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseUserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseUserResponse {
    @NotNull
    private final CertificateCourseUserId certificateCourseUserId;
    @NotNull
    private final String message;
}
