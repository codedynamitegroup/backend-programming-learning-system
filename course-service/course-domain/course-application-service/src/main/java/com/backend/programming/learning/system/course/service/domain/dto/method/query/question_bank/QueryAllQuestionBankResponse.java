package com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank.QuestionBankResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 4:19 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionBankResponse {
    List<QuestionBankResponseEntity> questionBanks;
    private int currentPage;
    private long totalItems;
    private int totalPages;
}
