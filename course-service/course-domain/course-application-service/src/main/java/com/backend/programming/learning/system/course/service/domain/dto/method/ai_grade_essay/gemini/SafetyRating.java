package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SafetyRating {
    @JsonProperty("category")
    private String category;

    @JsonProperty("probability")
    private String probability;

    // Getters and Setters
}
