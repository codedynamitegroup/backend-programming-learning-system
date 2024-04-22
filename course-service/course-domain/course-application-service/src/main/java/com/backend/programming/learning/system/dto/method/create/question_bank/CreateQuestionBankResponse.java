package com.backend.programming.learning.system.dto.method.create.question_bank;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:42 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateQuestionBankResponse {
    private UUID organizationId;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private Float defaultMark;
    private QuestionType qtype;
    private UUID questionBankCategoryId;
    private UUID createdBy;
    private String message;
}
