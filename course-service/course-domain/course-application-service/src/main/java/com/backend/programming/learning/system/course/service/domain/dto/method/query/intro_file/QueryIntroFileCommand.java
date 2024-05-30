package com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryIntroFileCommand {
    private UUID assignmentId;
}
