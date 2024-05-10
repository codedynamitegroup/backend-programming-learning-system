package com.backend.programming.learning.system.code.assessment.service.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {
    UUID id;
    String content;
    Integer numOfReply;
    Integer totalVote;
    UUID replyId;
    ZonedDateTime createdAt;
}
