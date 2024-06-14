package com.backend.programming.learning.system.course.service.domain.dto.method.message;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AnswerOfQuestionMessage {
    private String id;
    private String questionId;
    private String answer;
    private String feedback;
    private Float fraction;
}
