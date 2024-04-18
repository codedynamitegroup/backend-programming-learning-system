package com.backend.programming.learning.system.core.service.domain.dto.method.update.question;

import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**********************************************************************
 * UpdateQuestionUpdateEntity
 * Description: This class represents the Question entity when updating
 * Scope: Only for update method of Question and Qtype Question
 **********************************************************************/

@Builder
@AllArgsConstructor
@Getter
public class UpdateQuestionUpdateEntity {
    private final UUID questionId;
    private final QuestionDifficulty difficulty;
    private final String name;
    private final String questionText;
    private final String generalFeedback;
    private final float defaultMark;
    private final UUID updatedBy;
    private final List<AnswerOfQuestionUpdateEntity> answers;
}
