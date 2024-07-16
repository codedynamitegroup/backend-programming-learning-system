package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QuestionRequest {
    private String id;
    private String sagaId;
    private String organizationId;
    private String createdBy;
    private String updatedBy;
    private String difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private BigDecimal defaultMark;
    private UUID qtypeId;
    private String inputFormat;
    private String outputFormat;
    private String constraint;
    private Boolean isPublic;
    private Boolean allowImport;
    private Boolean isQuestionBank;
    private UUID categoryId;
    private String qType;
}
