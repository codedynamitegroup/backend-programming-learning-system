package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllAssignmentsCommand {

    private final UUID courseId;

}
