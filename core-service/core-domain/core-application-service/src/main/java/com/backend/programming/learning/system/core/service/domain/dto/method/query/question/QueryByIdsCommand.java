package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import java.util.List;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/31/2024 - 11:22 PM
 * Description: ...
 */

public record QueryByIdsCommand(
        List<QuestionCommand> questionCommands
) {
}
