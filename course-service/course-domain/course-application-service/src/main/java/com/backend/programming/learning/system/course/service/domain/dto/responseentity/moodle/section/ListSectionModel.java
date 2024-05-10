package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSectionModel {
    private List<SectionModel> sections;
}
