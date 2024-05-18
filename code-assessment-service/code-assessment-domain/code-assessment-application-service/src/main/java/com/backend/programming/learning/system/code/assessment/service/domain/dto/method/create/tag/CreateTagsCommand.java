package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.tag;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CreateTagsCommand {
    @NotNull(message = "tags must not be null")
    List<@Valid TagDto> tags;
}
