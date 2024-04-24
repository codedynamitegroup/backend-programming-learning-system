package com.backend.programming.learning.system.dto.responseentity.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:51 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QuestionBankResponseEntity {
    private UUID questionBankId;
    private UUID organizationId;
    private String name;
}
