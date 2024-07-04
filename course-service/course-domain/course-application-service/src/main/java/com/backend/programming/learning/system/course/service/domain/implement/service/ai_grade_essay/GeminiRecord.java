package com.backend.programming.learning.system.course.service.domain.implement.service.ai_grade_essay;

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

@Data
class Candidate {
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

@Data
class Content {
    @JsonProperty("parts")
    private List<Part> parts;

    @JsonProperty("role")
    private String role;

    // Getters and Setters
}

@Data
class Part {
    @JsonProperty("text")
    private String text;

    // Getters and Setters
}

@Data
class SafetyRating {
    @JsonProperty("category")
    private String category;

    @JsonProperty("probability")
    private String probability;

    // Getters and Setters
}

@Data
class UsageMetadata {
    @JsonProperty("promptTokenCount")
    private int promptTokenCount;

    @JsonProperty("candidatesTokenCount")
    private int candidatesTokenCount;

    @JsonProperty("totalTokenCount")
    private int totalTokenCount;

    // Getters and Setters
}
