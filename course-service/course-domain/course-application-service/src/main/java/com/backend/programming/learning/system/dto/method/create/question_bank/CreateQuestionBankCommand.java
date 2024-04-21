package com.backend.programming.learning.system.dto.method.create.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
public class CreateQuestionBankCommand {
    private UUID organizationId;
    private String name;
}
