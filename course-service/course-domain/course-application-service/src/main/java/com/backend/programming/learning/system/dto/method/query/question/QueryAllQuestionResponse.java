package com.backend.programming.learning.system.dto.method.query.question;

import com.backend.programming.learning.system.dto.responseentity.question.QuestionResponseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:24 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionResponse {
    private List<QuestionResponseEntity> questions;
    private int currentPage;
    private long totalItems;
    private int totalPages;
}
