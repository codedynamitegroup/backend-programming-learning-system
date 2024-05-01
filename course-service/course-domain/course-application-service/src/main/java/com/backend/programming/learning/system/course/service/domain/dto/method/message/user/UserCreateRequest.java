package com.backend.programming.learning.system.course.service.domain.dto.method.message.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class UserCreateRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean isDeleted;
}
