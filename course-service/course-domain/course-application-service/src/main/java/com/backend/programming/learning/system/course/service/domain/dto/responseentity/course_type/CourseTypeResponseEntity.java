package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type;

import lombok.Builder;

import java.util.UUID;

@Builder

public  record CourseTypeResponseEntity (
    UUID courseTypeId,
    UUID organizationId,
    Integer moodleId,
    String name

){}
