package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleDetail {
    private Integer id;
    private Integer course;
    private Integer module;
    private String name;
    private String modname;
    private Integer instance;
    private Integer section;
    private Integer sectionnum;
    private Integer groupmode;
    private Integer groupingid;
    private Integer completion;
    private String idnumber;
    private Integer added;
    private Integer score;
    private Integer indent;
    private Integer visible;
    private Integer visibleoncoursepage;
    private Integer visibleold;
    private Integer completiongradeitemnumber;
    private Integer completionpassgrade;
    private Integer completionview;
    private Integer completionexpected;
    private Integer showdescription;
    private Integer downloadcontent;
    private String availability;
    private Integer grade;
    private String gradepass;
    private Integer gradecat;
    private Object advancedgrading;
}
