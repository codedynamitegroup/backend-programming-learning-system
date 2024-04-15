package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;
@Getter
@Builder
@AllArgsConstructor
public class UsersUpdate {
    private String userId;
    private String name;
    private String email;
    private String firstName;
    private String lastName;
    private Date dob;
    private String avatarUrl;
    private Instant createdAt;
    private Instant updatedAt;
}
