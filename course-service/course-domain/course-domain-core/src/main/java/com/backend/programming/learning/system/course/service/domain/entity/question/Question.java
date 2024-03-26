package com.backend.programming.learning.system.course.service.domain.entity.question;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.course.service.domain.entity.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:42 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
public class Question {
    private Long id;
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
