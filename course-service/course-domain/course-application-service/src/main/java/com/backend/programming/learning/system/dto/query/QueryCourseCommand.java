package com.backend.programming.learning.system.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCourseCommand {
    @NotNull
    private final UUID courseId;
}
