package com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QueryAllChaptersResponse {
    @NotNull
    @JsonProperty("chapters")
    private final List<ChapterResponseEntity> chapters;
}
