package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.shared_solution.comment;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.CommentDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Builder
@Getter
public class CreateCommentResponse {
    @NotNull
    CommentDto comment;
}
