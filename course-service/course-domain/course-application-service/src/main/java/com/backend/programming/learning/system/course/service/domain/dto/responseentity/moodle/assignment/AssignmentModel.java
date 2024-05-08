package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentModel {
    private String id;
    private String cmid;
    private String course;
    private String name;
    private Integer nosubmissions;
    private Integer submissiondrafts;
    private Integer sendnotifications;
    private Integer sendlatenotifications;
    private Integer sendstudentnotifications;
    private Integer duedate;
    private Integer allowsubmissionsfromdate;
    private Integer grade;
    private Integer timemodified;
    private Integer completionsubmit;
    private Integer cutoffdate;
    private Integer gradingduedate;
    private Integer teamsubmission;
    private Integer requireallteammemberssubmit;
    private Integer teamsubmissiongroupingid;
    private Integer blindmarking;
    private Integer hidegrader;
    private Integer revealidentities;
    private String attemptreopenmethod;
    private Integer maxattempts;
    private Integer markingworkflow;
    private Integer markingallocation;
    private Integer requiresubmissionstatement;
    private Integer preventsubmissionnotingroup;
    private List<AssignmentConfigModel> configs;
    private String intro;
    private Integer introformat;
    private Object introfiles;
    private Object introattachments;
    private Integer timelimit;
    private Integer submissionattachments;

}
