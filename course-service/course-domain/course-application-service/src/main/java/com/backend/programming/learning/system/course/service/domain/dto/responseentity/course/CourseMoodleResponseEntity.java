package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.course
 * Create by Dang Ngoc Tien
 * Date 4/30/2024 - 11:46 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CourseMoodleResponseEntity {
    String id;
    String shortname;
    String fullname;
    String displayname;
    Long enrolledusercount;
    String idnumber;
    Integer visible;
    String summary;
    Integer summaryformat;
    String format;
    Boolean showgrades;
    String lang;
    Boolean enablecompletion;
    Boolean completionhascriteria;
    Boolean completionusertracked;
    Integer category;
    String progress;
    Boolean completed;
    Long startdate;
    Long enddate;
    Integer marker;
    Long lastaccess;
    Boolean isfavourite;
    Boolean hidden;
//    String overviewfiles;
    Boolean showactivitydates;
    Boolean showcompletionconditions;
    Long timemodified;
}
