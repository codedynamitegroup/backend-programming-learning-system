package com.backend.programming.learning.system.code.assessment.service.domain.dto.message;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class QuestionsUpdate {
    private String questionId;
    private String organizationId;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private float defaultMark;
    private String createdBy;
    private UserId updatedBy;
    private QuestionType qtype;
    private Instant createdAt;
    private Instant updatedAt;
}
