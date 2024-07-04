package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsageMetadata {
    @JsonProperty("promptTokenCount")
    private int promptTokenCount;

    @JsonProperty("candidatesTokenCount")
    private int candidatesTokenCount;

    @JsonProperty("totalTokenCount")
    private int totalTokenCount;

    // Getters and Setters
}
