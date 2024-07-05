package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.rubric;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Rubric {
    private List<Criteria> criteria;
    private String name;

    // Getters and setters

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


