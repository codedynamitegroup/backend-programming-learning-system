package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.gemini;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Part {
    @JsonProperty("text")
    private String text;
}
