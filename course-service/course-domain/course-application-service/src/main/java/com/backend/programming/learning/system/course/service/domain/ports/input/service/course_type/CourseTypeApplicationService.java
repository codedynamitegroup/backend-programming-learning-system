package com.backend.programming.learning.system.course.service.domain.ports.input.service.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course_type.DeleteCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryAllCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type.QueryCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.course_type.UpdateCourseTypeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface CourseTypeApplicationService {
    QueryAllCourseTypeResponse findAll();

    QueryAllCourseTypeResponse findAllByOrganizationId(@Valid QueryCourseTypeCommand queryCourseTypeCommand);


   CreateCourseTypeResponse createCourseType(@Valid CreateCourseTypeCommand createCourseTypeCommand);

   UpdateCourseTypeResponse updateCourseType(@Valid UpdateCourseTypeCommand updateCourseTypeCommand);

    DeleteCourseTypeResponse deleteCourseType(UUID courseTypeId);

    CourseTypeResponseEntity findById(UUID courseTypeId);
}
