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
public class ModuleContent {
    private String type;
    private String filename;
    private String filepath;
    private Integer filesize;
    private String fileurl;
    private Integer timecreated;
    private Integer timemodified;
    private Integer sortorder;
    private String mimetype;
    private Boolean isexternalfile;
    private Integer userid;
    private String author;
    private String license;

}
