package com.backend.programming.learning.system.course.service.domain.dto.question.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.question.create
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:05 PM
 * Description: ...
 */
@Getter
@Builder
public class CreateQuestionCommand {
    private Long orgId;
    private String name;
    private String questionText;
    private String generalFeedback;
    private Boolean defaultMark;
    private Long createdBy;
    private Long updatedBy;
    private String qtype;
    private String difficulty;
}
