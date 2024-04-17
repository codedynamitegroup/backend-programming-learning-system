package com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryChapterCommand {
    @NotNull
    private final UUID chapterId;
}
