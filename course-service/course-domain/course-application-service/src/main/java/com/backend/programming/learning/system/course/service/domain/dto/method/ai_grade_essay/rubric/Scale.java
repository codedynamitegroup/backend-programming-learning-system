package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.rubric;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Scale {
    private int score;
    private String description;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
