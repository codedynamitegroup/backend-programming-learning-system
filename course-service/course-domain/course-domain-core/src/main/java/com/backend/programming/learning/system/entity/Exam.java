package com.backend.programming.learning.system.entity;

import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Exam extends AggregateRoot<ExamId> {
    private Course course;
    private String name;
    private Float score;
    private Float maxScore;

    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private ZonedDateTime timeLimit;

    private String intro;
    private String overdueHanding;
    private Boolean canRedoQuestions;
    private Integer maxAttempts;

    private Boolean shuffleAnswers;
    private String gradeMethod;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void initializeExam() {
        setId(new ExamId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
        updatedAt = ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM));
    }
}
