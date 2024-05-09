package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**********************************************************************
 * UpdateQuestionEntity
 * Description: This class represents the Question entity when updating
 * Scope: Only for update method of Question and Qtype Question
 **********************************************************************/

@Builder
@AllArgsConstructor
@Getter
public class UpdateQuestionEntity {
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final Float defaultMark;

    @NotNull
    private final UUID updatedBy;
    private final List<AnswerOfQuestionUpdateEntity> answers;
}
