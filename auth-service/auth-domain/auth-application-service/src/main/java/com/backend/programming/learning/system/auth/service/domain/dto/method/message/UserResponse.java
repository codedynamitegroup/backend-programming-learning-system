package com.backend.programming.learning.system.auth.service.domain.dto.method.message;

import com.backend.programming.learning.system.domain.valueobject.UserResponseStatus;
import com.backend.programming.learning.system.domain.valueobject.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private Instant dob;
    private Instant createdAt;
    private Instant updatedAt;
    private UserResponseStatus userResponseStatus;
    private Boolean isDeleted;
    private List<String> failureMessages;
}
