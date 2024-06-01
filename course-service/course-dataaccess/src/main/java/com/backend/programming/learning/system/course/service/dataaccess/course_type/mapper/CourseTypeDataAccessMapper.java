package com.backend.programming.learning.system.course.service.dataaccess.course_type.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course_type.entity.CourseTypeEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseTypeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseTypeDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    public CourseTypeEntity courseTypeToCourseTypeEntity(CourseType courseType) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.organizationToOrganizationEntity(courseType.getOrganization());
        return CourseTypeEntity.builder()
                .id(courseType.getId().getValue())
                .moodleId(courseType.getMoodleId())
                .name(courseType.getName())
                .organization(organizationEntity)
                .build();
    }
    public CourseType courseTypeEntityToCourseType(CourseTypeEntity courseTypeEntity) {
        Organization organization = organizationDataAccessMapper.organizationEntityToOrganization(courseTypeEntity.getOrganization());
       CourseType response = CourseType.builder()
                .name(courseTypeEntity.getName())
                .moodleId(courseTypeEntity.getMoodleId())
                .organization(organization)
                .build();
        response.setId(new CourseTypeId(courseTypeEntity.getId()));
        return response;
    }

    public List<CourseType> courseTypeEntityListToCourseTypeList(List<CourseTypeEntity> all) {
        return all.stream().map(this::courseTypeEntityToCourseType).toList();
    }
}
