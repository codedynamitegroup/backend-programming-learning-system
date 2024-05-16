package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class UserDto {
    UUID id;
    String firstName;
    String lastName;
    String avatarUrl;
}
