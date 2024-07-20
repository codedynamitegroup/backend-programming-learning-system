package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_type.DeleteCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.mapper.course_type.CourseTypeDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CourseTypeCommandHandler {

    private final CourseTypeQueryHelper courseTypeQueryHelper;
    private final CourseTypeDataMapper courseTypeDataMapper;
    private final CourseTypeCreateHelper courseTypeCreateHelper;
    private final CourseTypeUpdateHelper courseTypeUpdateHelper;
    private final CourseTypeDeleteHelper courseTypeDeleteHelper;

    @Transactional(readOnly = true)
    public QueryAllCourseTypeResponse findAll()
    {
        return null;
    }

    @Transactional(readOnly = true)
    public CourseTypeResponseEntity findById(UUID courseTypeId)
    {
        return courseTypeDataMapper.mapToCourseTypeResponseEntity(
                courseTypeQueryHelper.findById(courseTypeId));
    }

    @Transactional(readOnly = true)
    public QueryAllCourseTypeResponse findAllByOrganizationId(QueryCourseTypeCommand queryCourseTypeCommand)
    {
        return courseTypeDataMapper.
                mapToQueryAllCourseTypeResponse(courseTypeQueryHelper.
                        findAllByOrganizationId(queryCourseTypeCommand));
    }

    @Transactional
    public CreateCourseTypeResponse createCourseType(CreateCourseTypeCommand createCourseTypeCommand) {
        CourseType courseType = courseTypeCreateHelper.createCourseType(createCourseTypeCommand);
        return CreateCourseTypeResponse.builder()
                .id(courseType.getId().getValue())
                .message("Course type created successfully")
                .build();
    }

    @Transactional
    public UpdateCourseTypeResponse updateCourseType(UpdateCourseTypeCommand updateCourseTypeCommand) {
        CourseType courseType = courseTypeUpdateHelper.updateCourseType(updateCourseTypeCommand);
        return UpdateCourseTypeResponse.builder()
                .id(courseType.getId().getValue())
                .message("Course type updated successfully")
                .build();
    }

    @Transactional
    public DeleteCourseTypeResponse deleteCourseType(UUID courseTypeId) {
        courseTypeDeleteHelper.deleteCourseType(courseTypeId);
        return DeleteCourseTypeResponse.builder()
                .id(courseTypeId)
                .message("Course type deleted successfully")
                .build();
    }
}
