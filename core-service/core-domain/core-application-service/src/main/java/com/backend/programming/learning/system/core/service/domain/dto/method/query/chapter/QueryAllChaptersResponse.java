package com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllChaptersResponse {
    @NotNull
    private final List<ChapterResponseEntity> chapters;
}
