package com.backend.programming.learning.system.core.service.dataaccess.chapter_resource.projection;

import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;

public interface CourseTypeCountProjection {
    String getResourceType();
    Long getCount();
}
