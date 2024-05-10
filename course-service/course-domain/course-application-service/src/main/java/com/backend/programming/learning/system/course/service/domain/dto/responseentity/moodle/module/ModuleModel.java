package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleModel {
    private String id;
    private String url;
    private String name;
    private Integer instance;
    private Integer contextid;
    private Integer visible;
    private Boolean uservisible;
    private Integer visibleoncoursepage;
    private String modicon;
    private String modname;
    private String modplural;
    private String availability;
    private Integer indent;
    private String onclick;
    private String afterlink;
    private String customdata;
    private Boolean noviewlink;
    private Integer completion;
    private Object completiondata;
    private Integer downloadcontent;
    private List<TimeFrame> dates;
}
