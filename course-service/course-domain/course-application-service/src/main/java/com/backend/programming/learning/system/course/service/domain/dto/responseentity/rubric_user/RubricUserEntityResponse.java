package com.backend.programming.learning.system.course.service.domain.dto.responseentity.rubric_user;

import com.backend.programming.learning.system.course.service.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RubricUserEntityResponse {
    private String id;
    private String content;
    private String name;
    private String description;
}
