package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    private String id;
    private String shortname;
    private Integer categoryid;
    private Integer categorysortorder;
    private String fullname;
    private String displayname;
    private String idnumber;
    private String summary;
    private String summaryformat;
    private String format;
    private String showgrades;
    private String newsitems;
    private String startdate;
    private String enddate;
    private String numsections;
    private String maxbytes;
    private String showreports;
    private Integer visible;
    private Integer hiddensections;
    private String groupmode;
    private String groupmodeforce;
    private String defaultgroupingid;
    private Integer timecreated;
    private Integer timemodified;
    private String enablecompletion;
    private String completionnotify;
    private String lang;
    private String forcetheme;
    private List<CourseFormat> courseformatoptions;
    private String showactivitydates;
    private String showcompletionconditions;

}
