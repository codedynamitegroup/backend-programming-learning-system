package com.backend.programming.learning.system.dto.method.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QuestionDeleteRequest {
    private String id;
}
