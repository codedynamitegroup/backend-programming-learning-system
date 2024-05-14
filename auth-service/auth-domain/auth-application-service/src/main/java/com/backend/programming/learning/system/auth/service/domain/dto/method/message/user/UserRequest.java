package com.backend.programming.learning.system.auth.service.domain.dto.method.message.user;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String username;
    private UUID organizationId;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String avatarUrl;
    private Instant dob;
    private CopyState copyState;
    private ServiceName serviceName;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean isDeleted;
}
