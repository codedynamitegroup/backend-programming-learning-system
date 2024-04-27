package com.backend.programming.learning.system.course.service.domain.dto.method.message.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class UserUpdateRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String avatarUrl;
    private Instant dob;
    private String phone;
    private Instant updatedAt;
}
