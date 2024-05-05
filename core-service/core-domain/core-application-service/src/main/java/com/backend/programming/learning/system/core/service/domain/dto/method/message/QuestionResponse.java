package com.backend.programming.learning.system.core.service.domain.dto.method.message;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QuestionResponse {
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
    private String qType;
    private CopyState copyState;
}
