package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GeminiRecord {
    @JsonProperty("candidates")
    private List<Candidate> candidates;

    @JsonProperty("usageMetadata")
    private UsageMetadata usageMetadata;

    // Getters and Setters
}

