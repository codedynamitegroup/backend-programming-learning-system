package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.tag;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class DeleteTagCommand {
    @NotNull(message = "tagId must not be null")
    UUID tagId;
}
