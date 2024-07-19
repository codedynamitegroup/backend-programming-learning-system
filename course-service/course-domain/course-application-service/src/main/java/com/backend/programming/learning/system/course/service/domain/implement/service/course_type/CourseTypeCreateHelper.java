package com.backend.programming.learning.system.course.service.domain.implement.service.course_type;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.course_type.CreateCourseTypeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.mapper.course_type.CourseTypeDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseTypeRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class CourseTypeCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CourseTypeRepository courseUserRepository;
    private final CourseTypeDataMapper courseUserDataMapper;
    private final OrganizationRepository organizationRepository;

    public CourseTypeCreateHelper(CourseDomainService courseDomainService, CourseTypeRepository courseUserRepository, CourseTypeDataMapper courseUserDataMapper, OrganizationRepository organizationRepository) {
        this.courseDomainService = courseDomainService;
        this.courseUserRepository = courseUserRepository;
        this.courseUserDataMapper = courseUserDataMapper;
        this.organizationRepository = organizationRepository;
    }

    @Transactional
    public CourseType createCourseType(CreateCourseTypeCommand createCourseTypeCommand) {
        Organization organization = getOrganization(createCourseTypeCommand.organizationId());
        CourseType courseType = courseUserDataMapper.createCourseTypeCommandToCourseType(createCourseTypeCommand);
        courseType.setOrganization(organization);
        courseDomainService.createCourseType(courseType);
        CourseType courseTypeSaved = courseUserRepository.save(courseType);
        return courseTypeSaved;
    }

    private Organization getOrganization(UUID organizationId) {
         Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CourseDomainException("Course not found");
        }
        return organization.get();
    }
}
