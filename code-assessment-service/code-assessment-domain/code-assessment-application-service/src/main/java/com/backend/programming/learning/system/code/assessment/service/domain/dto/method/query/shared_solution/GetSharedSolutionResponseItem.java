package com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.shared_solution;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSharedSolutionResponseItem {

    @NotNull
    User user;
    @NotNull
    Integer totalVote;
    @NotNull
    Integer totalView;
    @NotNull
    Integer totalComment;

    ZonedDateTime createdAt;

    String content;
    String title;

    List<Tag> tags;

    public void setTotalVote(@NotNull Integer totalVote) {
        this.totalVote = totalVote;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Tag{
        @NotNull
        UUID id;
        String name;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class User{
        @NotNull
        UUID id;

        String avatarUrl;
    }
}
