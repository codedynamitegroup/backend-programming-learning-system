package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.coure_type;

import lombok.*;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseTypeModel {
    private String id;
    private String name;
    private String idnumber;
    private String description;
    private Integer descriptionformat;
    private Integer parent;
    private Integer sortorder;
    private Integer coursecount;
    private Integer visible;
    private Integer visibleold;
    private Integer timemodified;
    private Integer depth;
    private String path;
    private String theme;

}
