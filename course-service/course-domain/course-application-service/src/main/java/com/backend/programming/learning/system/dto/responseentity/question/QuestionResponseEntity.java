package com.backend.programming.learning.system.dto.responseentity.question;

import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.Builder;

/**
 * com.backend.programming.learning.system.dto.responseentity.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:21 AM
 * Description: ...
 */
@Builder
public class QuestionResponseEntity {
    private QuestionId questionId;
    private OrganizationId organizationId;
    private QuestionDifficulty difficulty;
    private String name;
    private String questionText;
    private String generalFeedback;
    private float defaultMark;
    private String message;
}
