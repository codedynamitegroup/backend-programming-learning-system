package com.backend.programming.learning.system.dto.method.create.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:05 PM
 * Description: ...
 */
@Getter
@Builder
public class CreateQuestionCommand {
    private final UUID organizationId;
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final Float defaultMark;
    private final QuestionType qtype;
    private final UUID createdBy;
}
