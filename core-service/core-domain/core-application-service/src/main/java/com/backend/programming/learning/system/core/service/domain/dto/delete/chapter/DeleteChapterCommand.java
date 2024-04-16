package com.backend.programming.learning.system.core.service.domain.dto.delete.chapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteChapterCommand {
    @NotNull
    private final UUID chapterId;
}
