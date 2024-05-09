package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionModel {
    private String id;
    private String name;
    private Integer visible;
    private String summary;
    private String summaryformat;
    private String section;
    private String hiddenbynumsections;
    private Boolean uservisible;
//    private List<SectionModule> modules;
}
