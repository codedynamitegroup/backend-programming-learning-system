package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CreateTagsCommand {
    @NotNull(message = "tagNames must not be null")
    List<@NotNull String> tagNames;
}
