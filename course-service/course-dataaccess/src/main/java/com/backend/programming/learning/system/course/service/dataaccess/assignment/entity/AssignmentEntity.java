package com.backend.programming.learning.system.course.service.dataaccess.assignment.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignment", schema = "public")
@Entity
public class AssignmentEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    private String title;
    private String intro;
    private Float score;
    private Float maxScore;
    private ZonedDateTime timeOpen;
    private ZonedDateTime timeClose;
    private Integer timeLimit;
    private Integer type;
    private Boolean visible;





}
