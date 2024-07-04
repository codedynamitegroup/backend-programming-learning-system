package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Candidate {
    @JsonProperty("content")
    private Content content;

    @JsonProperty("finishReason")
    private String finishReason;

    @JsonProperty("index")
    private int index;

    @JsonProperty("safetyRatings")
    private List<SafetyRating> safetyRatings;

    // Getters and Setters
}
