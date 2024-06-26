package com.backend.programming.learning.system.course.service.domain.dto.method.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

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
    private String qType;
    private List<AnswerOfQuestionMessage> answers;
}
