package com.backend.programming.learning.system.core.service.domain.outbox.model.question;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class QuestionEventPayload {
    @JsonProperty
    private String inputFormat;

    @JsonProperty
    private String outputFormat;

    @JsonProperty
    private String constraint;

    @JsonProperty
    private Boolean allowImport;

    @JsonProperty
    private Boolean isPublic;

    @JsonProperty
    private String id;

    @JsonProperty
    private String qtypeId;

    @JsonProperty
    private String categoryId;

    @JsonProperty
    private String organizationId;

    @JsonProperty
    private String createdBy;

    @JsonProperty
    private String updatedBy;

    @JsonProperty
    private String difficulty;

    @JsonProperty
    private String name;

    @JsonProperty
    private String questionText;

    @JsonProperty
    private String generalFeedback;

    @JsonProperty
    private BigDecimal defaultMark;

    @JsonProperty
    private String qType;

    @JsonProperty
    private List<QuestionEventAnswer> answers;

    @JsonProperty
    private CopyState copyState;

    @JsonProperty
    private ZonedDateTime createdAt;

    @JsonProperty
    private ZonedDateTime updatedAt;
}
