package com.backend.programming.learning.system.course.service.domain.implement.service.ai_grade_essay;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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

@NoArgsConstructor
class Criteria {
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

@NoArgsConstructor
 class Scale {
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
