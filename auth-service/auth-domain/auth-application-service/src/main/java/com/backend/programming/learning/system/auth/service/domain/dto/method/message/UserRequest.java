package com.backend.programming.learning.system.auth.service.domain.dto.method.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class UserRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String email;
    private String displayName;
    private String avatarUrl;
    private Date dob;
    private Instant createdAt;
    private Boolean isDeleted;
}
