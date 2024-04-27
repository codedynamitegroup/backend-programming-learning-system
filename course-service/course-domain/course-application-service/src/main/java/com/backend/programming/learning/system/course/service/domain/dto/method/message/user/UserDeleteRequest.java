package com.backend.programming.learning.system.course.service.domain.dto.method.message.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDeleteRequest {
    private String id;
    private String sagaId;
    private String userId;
    private Boolean isDeleted;
}
