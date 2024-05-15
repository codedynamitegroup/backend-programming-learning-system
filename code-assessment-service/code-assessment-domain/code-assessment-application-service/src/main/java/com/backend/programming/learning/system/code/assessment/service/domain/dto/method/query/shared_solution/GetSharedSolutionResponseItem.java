package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.UserDto;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.Vote;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.TagDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSharedSolutionResponseItem {

    @NotNull
    UserDto user;
    @NotNull
    UUID sharedSolutionId;
    @NotNull
    Integer totalVote;
    @NotNull
    Integer totalView;
    @NotNull
    Integer totalComment;

    ZonedDateTime createdAt;

    String content;
    String title;

    Vote youVote;

    List<TagDto> tags;

}
