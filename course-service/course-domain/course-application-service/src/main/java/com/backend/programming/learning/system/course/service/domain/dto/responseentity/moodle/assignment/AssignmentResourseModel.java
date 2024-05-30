package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment;

import lombok.*;

@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResourseModel {
    private String filename;
    private String filepath;
    private Integer filesize;
    private String fileurl;
    private Integer timemodified;
    private String mimetype;
    private Boolean isexternalfile;
}
