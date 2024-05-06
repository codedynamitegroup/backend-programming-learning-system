package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course
 * Create by Dang Ngoc Tien
 * Date 5/6/2024 - 11:18 PM
 * Description: ...
 */
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    String id;
    String shortname;
    Long categoryid;
    Long categorysortorder;
    String fullname;
    String displayname;
    String idnumber;
    String summary;
    Integer summaryformat;
    String format;
    Boolean showgrades;
    Integer newsitems;
    Long startdate;
    Long enddate;
    Integer numsections;
    Long maxbytes;
    Boolean showreports;
    Boolean visible;
    Integer hiddensections;
    Integer groupmode;
    Integer groupmodeforce;
    Long defaultgroupingid;
    Long timecreated;
    Long timemodified;
    Boolean enablecompletion;
    Integer completionnotify;
    String lang;
    String forcetheme;
    Object courseformatoptions;
    Boolean showactivitydates;
    Boolean showcompletionconditions;
}
