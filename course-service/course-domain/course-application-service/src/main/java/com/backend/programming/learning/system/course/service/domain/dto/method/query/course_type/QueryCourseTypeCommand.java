package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCourseTypeCommand {

    private final UUID OrganizationId;
}
