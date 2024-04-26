package com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.update.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 4:37 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class UpdateQuestionBankResponse {
    private UUID questionBankId;
    private UUID organizationId;
    private String name;
    private String message;
}
