package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.rubric;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Criteria {
    private String criteriaName;
    private Integer criteriaGrade;
    private String criteriaDescription;
    private List<Scale> scale;

    // Getters and setters

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public Integer getCriteriaGrade() {
        return criteriaGrade;
    }

    public void setCriteriaGrade(Integer criteriaGrade) {
        this.criteriaGrade = criteriaGrade;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    public List<Scale> getScale() {
        return scale;
    }

    public void setScale(List<Scale> scale) {
        this.scale = scale;
    }
}
