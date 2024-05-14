package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseModel {
    private String id;
    private String shortname;
    private String fullname;
    private String displayname;
    private Integer enrolledusercount;
    private String idnumber;
    private Integer visible;
    private String courseimage;

    private String summary;
    private String summaryformat;
    private String format;
    private Boolean showgrades;
    private String lang;
    private Boolean enablecompletion;
    private Boolean completionhascriteria;
    private Boolean completionusertracked;
    private Integer category;
    private String progress;
    private String completed;
    private Integer startdate;
    private Integer enddate;
    private String marker;
    private Integer lastaccess;
    private Boolean isfavourite;
    private Boolean hidden;
    private Object overviewfiles;
    private Boolean showactivitydates;
    private Boolean showcompletionconditions;
    private Integer timemodified;


}
