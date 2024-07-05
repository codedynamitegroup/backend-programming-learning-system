package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Content {
    @JsonProperty("parts")
    private List<Part> parts;

    @JsonProperty("role")
    private String role;

    // Getters and Setters
}
