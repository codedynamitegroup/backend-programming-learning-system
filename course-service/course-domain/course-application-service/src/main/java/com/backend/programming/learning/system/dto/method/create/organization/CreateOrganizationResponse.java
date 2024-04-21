package com.backend.programming.learning.system.dto.method.create.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.aspectj.bridge.IMessage;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrganizationResponse {
    private final UUID organizationId;
    private final String name;
    private final String message;
}
