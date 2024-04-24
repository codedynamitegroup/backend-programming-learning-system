package com.backend.programming.learning.system.core.service.domain.dto.method.message.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class UserDeleteRequest {
    private String id;
    private String sagaId;
    private String userId;
    private Boolean isDeleted;
}
