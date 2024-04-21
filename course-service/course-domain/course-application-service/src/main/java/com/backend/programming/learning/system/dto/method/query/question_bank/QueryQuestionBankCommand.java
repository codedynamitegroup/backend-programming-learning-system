package com.backend.programming.learning.system.dto.method.query.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 4:20 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryQuestionBankCommand {
    private UUID questionBankId;
}
