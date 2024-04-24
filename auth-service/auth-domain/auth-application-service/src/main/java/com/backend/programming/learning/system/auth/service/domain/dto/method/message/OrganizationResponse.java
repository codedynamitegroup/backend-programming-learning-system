package com.backend.programming.learning.system.auth.service.domain.dto.method.message;

import com.backend.programming.learning.system.domain.valueobject.OrganizationResponseStatus;
import com.backend.programming.learning.system.domain.valueobject.UserResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class OrganizationResponse {
    private String id;
    private String sagaId;
    private String organizationId;
    private OrganizationResponseStatus organizationResponseStatus;
    private List<String> failureMessages;
}
