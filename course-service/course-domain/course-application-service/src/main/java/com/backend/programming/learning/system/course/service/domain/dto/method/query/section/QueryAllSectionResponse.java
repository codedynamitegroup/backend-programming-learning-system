package com.backend.programming.learning.system.course.service.domain.dto.method.query.section;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.section.SectionResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllSectionResponse {
    private UUID courseId;
    List<SectionResponseEntity> sections;
}
